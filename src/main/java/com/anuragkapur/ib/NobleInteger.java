package com.anuragkapur.ib;

/*
[3, 2, 1, 3]

approach 1:
for each integer, iterate over array to count number of integers greater.
RTC: O(n^2)

approach 2:
sort - O(nlogn)
1, 2, 3, 3
length = 4
iterate
 if next == current
   continue
 if current == length-current.index-1
RTC: O(nlogn)

todo
Arrays.sort - inc/dec ordering
*/

import java.util.Arrays;

public class NobleInteger {

    public int solve(int[] A) {

        Arrays.sort(A);

        if (A[A.length-1] == 0) {
            return 1;
        }

        for (int i=0; i<A.length-1; i++) {
            if (A[i+1] == A[i]) {
                continue;
            }

            if (A[i] == A.length-1-i) {
                return 1;
            }
        }

        return -1;
    }
}

