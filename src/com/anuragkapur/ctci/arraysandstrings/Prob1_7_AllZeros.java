package com.anuragkapur.ctci.arraysandstrings;

/**
 * @author: anuragkapur
 * @since: 07/05/2014
 */

public class Prob1_7_AllZeros {

    /**
     * Run time complexity: O(mn), where m is number of rows and n is number of columns
     * Space complexity:O(mn), One additional 2d array is used.
     *
     * @param a
     * @return
     */
    public static int[][] replaceMatrixElements(int a[][]) {

        int rows[] = new int[a.length];
        int columns[] = new int [a[0].length];

        for (int i=0; i<a.length; i++) {
            for(int j=0; j<a[i].length; j++) {
                if(a[i][j] == 0) {
                    rows[i] = 1;
                    columns[j] = 1;
                }

            }
        }

        for (int i=0; i<rows.length; i++) {
            if (rows[i] == 1) {
                for (int j=0; j<a[i].length; j++) {
                    a[i][j] = 0;
                }
            }
        }

        for (int i=0; i<columns.length; i++) {
            if (columns[i] == 1) {
                for (int j=0; j<a.length; j++) {
                    a[j][i] = 0;
                }
            }
        }

        return a;
    }

    public static void printMatrix(int matrix[][], int m, int n) {
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int m = 4, n = 4;
        int matrix[][] = new int[m][n];
        for(int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                matrix[i][j] = 1;
            }
        }

        matrix[2][1] = 0;
        matrix[0][3] = 0;

        System.out.println("Before");
        printMatrix(matrix, m, n);
        System.out.println(matrix.length + " :: " + matrix[0].length);
        replaceMatrixElements(matrix);

        System.out.println("After");
        printMatrix(matrix, m, n);
    }
}
