package com.anuragkapur.sorting;

/**
 * @author anuragkapur
 */
public class QuickSort {

    public void sort(int[] a, int start, int end) {

        if (end <= start) {
            return;
        }

        int partition = partition(a, start, end);
        sort(a, start, partition-1);
        sort(a, partition+1, end);

    }

    public int partition(int[] a, int start, int end) {

        int i = start;
        int x = a[end];

        for (int j = start; j < end; j++) {
            if (a[j] < x) {
                swap(a, i, j);
                i++;
            }
        }

        swap(a, i, end);

        return i;
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {6, 1, 3, 4, 2, 9, 5, 8, 7};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a, 0, a.length-1);
        for (int num : a) {
            System.out.println(num);
        }
    }
}
