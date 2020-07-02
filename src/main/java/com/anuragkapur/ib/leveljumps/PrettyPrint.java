package com.anuragkapur.ib.leveljumps;

public class PrettyPrint {
    public int[][] prettyPrint(int A) {
        int len = A * 2 - 1;
        int[][] ans = new int[len][len];
        for (int i=0; i<=len/2; i++) {
            int start = i;
            int end = len - 1 - i;
            for (int j=start; j<=end; j++) {
                ans[i][j] = A - i;
            }
            int current = A;
            for (int j=0; j<start; j++) {
                ans[i][j] = current;
                current --;
            }
            current = A;
            for (int j=len-1; j>end; j--) {
                ans[i][j] = current;
                current --;
            }
        }
        for (int i=A; i<len; i++) {
            ans[i] = ans[len - i - 1];
        }
        return ans;
    }

    public static void main(String[] args) {
        PrettyPrint p = new PrettyPrint();
        int[][] ans = p.prettyPrint(4);
        for (int i = 0; i < ans.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < ans[i].length; j++) {
                builder.append(ans[i][j]).append(" ");
            }
            System.out.println(builder.toString());
        }
    }
}
