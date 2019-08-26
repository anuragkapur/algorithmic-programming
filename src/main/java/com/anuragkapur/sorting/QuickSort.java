package com.anuragkapur.sorting;

/**
 * @author anuragkapur
 */
public class QuickSort {

    public void sort(int a[], int start, int end) {

        if (end <= start) {
            return;
        }

        int partition = partition(a, start, end);
        sort(a, start, partition-1);
        sort(a, partition+1, end);

    }

    public int partition(int a[], int start, int end) {

        int i = start - 1;
        int x = a[end];

        for (int j = start; j < end; j++) {
            if (a[j] < x) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        i++;
        int temp = a[i];
        a[i] = a[end];
        a[end] = temp;

        return i;
    }

}
