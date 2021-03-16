package com.liqinchun.knowledge.knowledge.juc.forkjoin.recursivetask;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * 计算斐波那契数列
 */
public class Fibonacci extends RecursiveTask {

    final int n;
    Fibonacci(int n) {
        this.n = n;
    }


    protected Integer compute() {
        if (n <= 1)
            return n;
        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        return f2.compute() + (Integer) f1.join();
    }

}
