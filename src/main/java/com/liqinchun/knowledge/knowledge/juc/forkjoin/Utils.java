package com.liqinchun.knowledge.knowledge.juc.forkjoin;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Utils {

    public static int[] buildRandomIntArray(int size) {
        int random;
        random = size;
        if (size > 1000) {
            random = 1000;
        }

        int array[] = new int[size];
        for (int i = 0 ;i<size;i++) {
            array[i] = new Random().nextInt(random);
        }

        return array;

    }

    public static long[] buildRandomLongArray(int size) {
        int random;
        random = size;
        if (size > 1000) {
            random = 1000;
        }

        long array[] = new long[size];
        for (int i = 0 ;i<size;i++) {
            array[i] = new Random().nextInt(random);
        }
        return array;
    }
}
