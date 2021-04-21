package com.liqinchun.knowledge.knowledge.juc.forkjoin.recursivetask;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final int THREAD_SHOLD = 2;
    private static  int COUNT = 0;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Integer compute() {
        System.out.println(++COUNT);
        int sum = 0;
        boolean canCompare = (end - start) <= THREAD_SHOLD;
        if (canCompare) {
            for (int i = start;i<= end;i++) {
                sum += i;
            }
        } else {
          int middle = (start + end) / 2;
          CountTask leftTask = new CountTask(start,middle);
          CountTask rightTask = new CountTask(middle+1,end);
          leftTask.fork();
          leftTask.join();
          rightTask.fork();
          int leftRest = leftTask.join();
          int rightResult = rightTask.join();

          sum = leftRest + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(1,4);
        Future result = forkJoinPool.submit(task);
        System.out.println(result.get());
    }
}
