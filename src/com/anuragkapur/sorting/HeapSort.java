package com.anuragkapur.sorting;

/**
 * @author anuragkapur
 */
public class HeapSort {

    /**
     * Running time: O(n log n)
     * @param a
     */
    public void sort(int a[]) {

        int heapSize = a.length - 1;
        buildMaxHeap(a, heapSize);

        for (int i=a.length-1; i>0; i--) {
            int max = a[0];
            a[0] = a[i];
            a[i] = max;

            maxHeapify(a, 0, heapSize--);
        }
    }

    /**
     * Running time: O(n log n) - correct but not tight enough, O(n) - asymptotically tight upper bound.
     *
     * @param a
     * @param heapSize
     */
    private void buildMaxHeap(int a[], int heapSize) {
        for (int i=(heapSize/2)-1; i>=0; i--) {
            maxHeapify(a, i, heapSize);
        }
    }

    /**
     * Running time: O(log n) where n is the number of elements in the tree rooted at i.
     *
     * @param a
     * @param i
     * @param heapSize
     */
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
