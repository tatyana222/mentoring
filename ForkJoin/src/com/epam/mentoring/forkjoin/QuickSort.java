package com.epam.mentoring.forkjoin;

import java.util.concurrent.RecursiveAction;

public class QuickSort extends RecursiveAction {

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
            int pivot = partition(data, left, right);
            invokeAll(new QuickSort(data, left, pivot),
                    new QuickSort(data, pivot + 1, right));
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
