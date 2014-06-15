package com.anuragkapur.ctci.recursionanddp;

/**
 * @author: anuragkapur
 * @since: 15/06/14
 */

public class Prob9_2_RobotInGrid {

    public int countPaths(int x, int y) {

        if(x <  0 || y < 0) {
            return 0;
        } else if(x == 0 && y != 0) {
            return 1;
        } else if(y == 0 && x != 0) {
            return 1;
        } else if( x == 0 && y == 0) {
            return 0;
        } else {
            int count = countPaths(x-1, y);
            count += countPaths(x, y-1);
            return count;
        }
    }
}
