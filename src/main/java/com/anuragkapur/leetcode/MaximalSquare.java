package com.anuragkapur.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author anuragkapur
 */
public class MaximalSquare {

    Map<String, Integer> areaLookup = new HashMap<>();

    public int maximalSquare(char matrix[][]) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int maxArea = 0;

        for (int i=0; i <matrix.length; i++) {
            for (int j=0; j < matrix[i].length; j++) {
                int area = (int)Math.pow(maximalSquareLengthFromPoint(matrix, i, j), 2);
                maxArea = (area > maxArea) ? area : maxArea;
            }
        }

        return maxArea;
    }

    private int maximalSquareLengthFromPoint(char matrix[][], int row, int column) {

        String areaLookupKey = String.valueOf(row)+","+String.valueOf(column);

        if (areaLookup.containsKey(areaLookupKey)) {
            return areaLookup.get(areaLookupKey);
        }

        if (matrix[row][column] == '0') {
            return 0;
        }

        if (row == matrix.length-1 || column == matrix[0].length-1) {
            return Character.getNumericValue(matrix[row][column]);
        }

        if (matrix[row][column+1] == 0 || matrix[row+1][column+1] == 0 || matrix[row+1][column] == 0) {
            return 0;
        }

        // compute areas of adjoining maximalSquares
        int area1 = maximalSquareLengthFromPoint(matrix, row, column + 1);
        int area2 = maximalSquareLengthFromPoint(matrix, row + 1, column + 1);
        int area3 = maximalSquareLengthFromPoint(matrix, row + 1, column);

        // maximalSquareLengthFromPoint starting with matrix[i][j]?
        int areas[] = new int[]{area1, area2, area3};
        Arrays.sort(areas);

        areaLookup.put(areaLookupKey, areas[0]+1);

        return areas[0]+1;
    }
}
