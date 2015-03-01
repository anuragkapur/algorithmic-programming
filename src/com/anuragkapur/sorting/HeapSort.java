package com.anuragkapur.sorting;

/**
 * @author anuragkapur
 */
public class HeapSort {

    public void sort(int a[]) {

        for (int i=0; i<a.length; i++) {
            int heapSize = a.length - i;
            buildMaxHeap(a, heapSize);
            int max = a[0];
            a[0] = a[heapSize-1];
            a[heapSize-1] = max;
        }
    }

    private void buildMaxHeap(int a[], int heapSize) {
        for (int i=(heapSize/2)-1; i>=0; i--) {
            maxHeapify(a, i, heapSize);
        }
    }

    private void maxHeapify(int a[], int i, int heapSize) {
        int left = left(i, a, heapSize);
        int right = right(i, a, heapSize);
        int largest = i;

        if (left == -1 && right == -1) {
            return;
        }

        if (left != -1 && a[left] > a[largest]) {
            largest = left;
        }

        if (right != -1 && a[right] > a[largest]) {
            largest = right;
        }

        if (largest == i) {
            return;
        }

        // swap a[i] and a[largest]
        int temp = a[i];
        a[i] = a[largest];
        a[largest] = temp;

        maxHeapify(a, largest, heapSize);
    }

    private int left(int i, int a[], int heapSize) {
        int left = ((i+1) * 2) - 1;
        if (left < heapSize) {
            return left;
        }
        return -1;
    }

    private int right(int i, int a[], int heapSize) {
        int right = ((i+1) * 2);
        if (right < heapSize) {
            return right;
        }
        return -1;
    }
}
