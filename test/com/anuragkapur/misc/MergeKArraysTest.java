package com.anuragkapur.misc;

import org.junit.Test;

public class MergeKArraysTest {

    @Test
    public void testMerge2Arrays() throws Exception {
        MergeKArrays obj = new MergeKArrays();
        int result[] = obj.merge2Arrays(new int[] {1,4,5,8,13,22}, new int[]{1,3,4,7,8,9});
        for (int i=0; i<result.length; i++) {
            System.out.println(result[i]);
        }
    }

    @Test
    public void testMergeKArrays() throws Exception {
        MergeKArrays obj = new MergeKArrays();
        int arrays[][] = new int[4][];
        arrays[0] = new int[6];
        arrays[0][0] = 1;
        arrays[0][1] = 4;
        arrays[0][2] = 5;
        arrays[0][3] = 8;
        arrays[0][4] = 13;
        arrays[0][5] = 22;

        arrays[1] = new int[6];
        arrays[1][0] = 1;
        arrays[1][1] = 3;
        arrays[1][2] = 4;
        arrays[1][3] = 7;
        arrays[1][4] = 8;
        arrays[1][5] = 9;

        arrays[2] = new int[6];
        arrays[2][0] = 5;
        arrays[2][1] = 10;
        arrays[2][2] = 12;
        arrays[2][3] = 21;
        arrays[2][4] = 22;
        arrays[2][5] = 23;

        arrays[3] = new int[6];
        arrays[3][0] = 7;
        arrays[3][1] = 8;
        arrays[3][2] = 9;
        arrays[3][3] = 19;
        arrays[3][4] = 24;
        arrays[3][5] = 25;

        int result[][] = obj.mergeKArrays(arrays);

        for (int i=0; i<result.length; i++) {
            for (int j=0; j<result[i].length; j++) {
                System.out.println(result[i][j]);
            }
        }
    }
}