package com.anuragkapur.ds.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DepthFirstTraversalTest {

    @Test
    public void testDft() throws Exception {
        List<Integer> values = new ArrayList<>();
        new DepthFirstTraversal().dft(TreeFactory.getBalancedBinaryTree(), values);
        assertEquals("[4, 1, 2, 4, 2, 3, 5, 7, 6]", values.toString());
    }
}