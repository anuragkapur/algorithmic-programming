package com.anuragkapur.ctci.recursionanddp;

/**
 * @author: anuragkapur
 * @since: 15/06/14
 */

public class Prob9_2_RobotInGrid {

    static int countCalls = 0;

    /**
     * Simple recursive solution. Has overlapping sub-problems and hence can be optimised by DP. The presence of
     * overlapping sub-problems is evident by inspecting the sysout in the else block below.
     *
     * @param x
     * @param y
     * @return
     */
    public int countPaths(int x, int y) {

        if(x == 0 && y == 0) {
            return 0;
        } else if(x == 0) {
            return 1;
        } else if(y == 0) {
            return 1;
        } else {
            countCalls ++;
            System.out.println(countCalls + " :: " + x + " :: " + y);
            int count = countPaths(x-1, y);
            count += countPaths(x, y-1);
            return count;
        }
    }
}
