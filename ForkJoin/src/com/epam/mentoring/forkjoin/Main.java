package com.epam.mentoring.forkjoin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int[] ints = random.ints(10000,0, 10001).toArray();

        System.out.println(Arrays.toString(ints));

        QuickSort quickSort = new QuickSort(ints);

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(quickSort);

        System.out.println(Arrays.toString(ints));
    }
}
