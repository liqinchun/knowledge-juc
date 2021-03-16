package com.liqinchun.knowledge.knowledge.juc.forkjoin.recursiveaction;

import com.liqinchun.knowledge.knowledge.juc.forkjoin.Utils;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        //创建ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ;
        SortTask sortTask = new SortTask(Utils.buildRandomLongArray(1000));
        forkJoinPool.submit(sortTask);
        forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);
        //关闭线程池
        forkJoinPool.shutdown();
    }
}
