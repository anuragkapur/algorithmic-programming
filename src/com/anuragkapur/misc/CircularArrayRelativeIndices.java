package com.anuragkapur.misc;

/**
 * @author anuragkapur
 */
public class CircularArrayRelativeIndices {

    public boolean hasCycle(int a[]) {

        if (a == null) {
            return false;
        }

        if (a.length < 2){
            return true;
        }

        int current = 0;

        for (int i = 0; i < a.length; i++) {
            int temp = current;
            current = (a[current] + current) % a.length;
            if (current < 0) {
                current += a.length;
            }
            a[temp] = 0;

            if (current == 0 && i < a.length-1) {
                return false;
            }
        }

        return current == 0;
    }
}
