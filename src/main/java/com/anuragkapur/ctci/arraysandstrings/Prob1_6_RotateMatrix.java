package com.anuragkapur.ctci.arraysandstrings;

/**
 * @author anuragkapur
 */
public class Prob1_6_RotateMatrix {

    /**
     * Running time = O(n^2), where n = length of size of square matrix
     *
     * @param a
     * @return
     */
    public int[][] rotate(int a[][]) {

        int start = 0;
        int end = a[0].length-1;

        while (start < end) {
            int offset = 0;
            for (int i=start; i<end; i++) {

                int temp = a[start][end-offset];

                // left -> top
                a[start][end-offset] = a[i][start];

                // bottom -> left
                a[i][start] = a[end][i];

                // right -> bottom
                a[end][i] = a[end-offset][end];

                // temp -> right
                a[end-offset][end] = temp;

                offset ++;
            }
            start ++;
            end --;
        }

        return a;
    }
}
