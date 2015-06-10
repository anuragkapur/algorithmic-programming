package com.anuragkapur.sorting;

/**
 * @author anuragkapur
 */
public class SelectionSort {

    public void recursiveSort(int a[]) {

        recursiveSort(a, 0);
    }

    private void recursiveSort(int a[], int start) {

        if (a == null || start >= a.length) {
            return;
        }

        int min = findIndexOfMin(a, start);
        swap(a, start, min);
        recursiveSort(a, start+1);
    }

    private void swap(int a[], int i1, int i2) {

        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }

    private int findIndexOfMin(int a[], int start) {

        int min = start;
        for (int i = start+1; i < a.length; i++) {
            if (a[i] < a[min])
                min = i;
        }

        return min;
    }

}
