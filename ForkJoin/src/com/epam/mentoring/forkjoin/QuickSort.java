package com.epam.mentoring.forkjoin;

import java.util.concurrent.RecursiveAction;

public class QuickSort extends RecursiveAction {

    private static final int THRESHOLD = 1000;

    private int[] data;
    private int left;
    private int right;

    public QuickSort(int[] data) {
        this.data = data;
        this.left = 0;
        this.right = data.length - 1;
    }

    public QuickSort(int[] data, int left, int right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        if (left < right) {
            // sort in one thread when number of elements is less than threshold = 1000
            // because splitting the task between threads has a cost and it is still much higher than simple recursive method call
            // that's why it's better to use multiple cores only when there is really large array
            if (right - left < THRESHOLD) {
                int pivot = QuickSortOneThread.partition(data, left, right);
                QuickSortOneThread.quicksort(data, left, pivot);
                QuickSortOneThread.quicksort(data, pivot + 1, right);
            } else {
                int pivot = partition(data, left, right);
                invokeAll(new QuickSort(data, left, pivot),
                        new QuickSort(data, pivot + 1, right));
            }
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low - 1;
        int j = high + 1;
        while (true) {
            do {
                i++;
            }
            while (array[i] < pivot);

            do {
                j--;
            }
            while (array[j] > pivot);
            if (i >= j)
                return j;

            swap(array, i, j);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
