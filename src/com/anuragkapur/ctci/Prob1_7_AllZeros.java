package com.anuragkapur.ctci;

/**
 * @author: anuragkapur
 * @since: 07/05/2014
 */

public class Prob1_7_AllZeros {

    // m columns and n rows
    public static void compute(int matrix[][], int m, int n) {


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
        int m = 3, n = 4;
        int matrix[][] = new int[m][n];
        for(int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                matrix[i][j] = 1;
            }
        }

        matrix[2][1] = 0;

        System.out.println("Before");
        printMatrix(matrix, m, n);
        System.out.println(matrix.length + " :: " + matrix[0].length);
        compute(matrix, m, n);

        System.out.println("After");
        printMatrix(matrix, m, n);
    }
}
