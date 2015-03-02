package com.anuragkapur.ctci.recursionanddp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Prob9_4_AllSubsetsTest {

    @Test
    public void testComputeSubsets1() throws Exception {
        Prob9_4_AllSubsets solution = new Prob9_4_AllSubsets();

        List<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);

        List<List<Integer>> subsets = solution.computeSubsets(set);
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for(List<Integer> subset : subsets) {
            builder.append("{");
            int count = subset.size();
            for(Integer element : subset) {
                count --;
                builder.append(element);
                if (count > 0)
                    builder.append(",");
            }
            builder.append("}");
        }
        builder.append("}");
        Assert.assertEquals("{{2}{}{2,1}{1}}", builder.toString());
    }

    @Test
    public void testComputeSubsets2() throws Exception {
        Prob9_4_AllSubsets solution = new Prob9_4_AllSubsets();

        List<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);

        List<List<Integer>> subsets = solution.computeSubsets(set);
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for(List<Integer> subset : subsets) {
            builder.append("{");
            int count = subset.size();
            for(Integer element : subset) {
                count --;
                builder.append(element);
                if (count > 0)
                    builder.append(",");
            }
            builder.append("}");
        }
        builder.append("}");
        Assert.assertEquals("{{3}{}{3,2}{2}{3,1}{1}{3,2,1}{2,1}}", builder.toString());
    }

    @Test
    public void testSubsets1() throws Exception {
        int a[] = {1,2};
        Assert.assertEquals("[[2], [], [2, 1], [1]]", new Prob9_4_AllSubsets().subsets(a, 0, a.length-1).toString());
    }

    @Test
    public void testSubsets2() throws Exception {
        int a[] = {1,2,3};
        Assert.assertEquals("[[3], [], [3, 2], [2], [3, 1], [1], [3, 2, 1], [2, 1]]", new Prob9_4_AllSubsets().subsets(a, 0, a.length-1).toString());
    }
}