package com.epam.mentoring.forkjoin;

public final class QuickSortOneThread {

    private QuickSortOneThread() {
    }

    public static void quicksort(int[] data, int left, int right) {
        if (left < right) {
            int pivot = partition(data, left, right);
            quicksort(data, left, pivot);
            quicksort(data, pivot + 1, right);
        }
    }

    public static int partition(int[] array, int low, int high) {
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

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
