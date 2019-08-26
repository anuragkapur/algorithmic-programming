package com.anuragkapur.ctci.recursionanddp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anuragkapur
 */
public class Prob9_5_StringPermutations {

    /**
     * Run time complexity: O(n * n!)
     * T(n) = (T(n-1) + (n-1)!) * n
     *
     * @param str
     * @return
     */
    public List<String> getPermutations(String str) {

        List<String> permutations = new ArrayList<>();

        if (str.length() == 1) {
            permutations.add(str);
            return permutations;
        }

        char chars[] = str.toCharArray();
        for(int i=0; i<chars.length; i++) {
            char ch = chars[i];
            StringBuilder subBuilder = new StringBuilder();
            for(int j=0; j<chars.length; j++) {
                if(j != i) {
                    subBuilder.append(chars[j]);
                }
            }
            List<String> subPerms = getPermutations(subBuilder.toString());
            for(String subPerm : subPerms) {
                permutations.add(String.valueOf(ch) + subPerm);
            }
        }

        return permutations;
    }

}
