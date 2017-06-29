package com.epam.mentoring.forkjoin;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        System.out.println("10 000 elements quicksort");
        Random random = new Random();
        int[] ints = random.ints(10000,0, 10001).toArray();

        System.out.println(Arrays.toString(ints));

        QuickSort quickSort = new QuickSort(ints);

        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(quickSort);

        System.out.println(Arrays.toString(ints));
        System.out.println();
        System.out.println("Sorted array size = " + ints.length);
        System.out.println();

        System.out.println("1 element quicksort");
        int[] oneElementInts = new int[1];
        oneElementInts[0] = 1;

        QuickSort oneElementQuickSort = new QuickSort(oneElementInts);
        pool.invoke(oneElementQuickSort);

        System.out.println(Arrays.toString(oneElementInts));
    }
}
