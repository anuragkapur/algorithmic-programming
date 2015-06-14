package com.anuragkapur.leetcode;

import java.util.Arrays;

/**
 * @author anuragkapur
 */
public class RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int area1 = (C-A)*(D-B);
        int area2 = (G-E)*(H-F);

        int xCoordinates[] = {A, C, E, G};
        int yCoordinates[] = {B, D, F, H};

        Arrays.sort(xCoordinates);
        Arrays.sort(yCoordinates);

        // is there an overlapping area?
        int commonArea = 0;
        if (overlap(A, B, C, D, E, F, G, H)) {
            commonArea = (xCoordinates[2]-xCoordinates[1]) * (yCoordinates[2]-yCoordinates[1]);
        }

        return area1+area2-commonArea;
    }

    private boolean overlap(int a, int b, int c, int d, int e, int f, int g, int h) {

        if (c <= e || g <= a || d <= f || h <= b) {
            return false;
        }

        return true;
    }
}
