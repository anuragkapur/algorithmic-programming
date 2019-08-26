package com.anuragkapur.ds.tree;

import java.util.List;

/**
 * @author anuragkapur
 */
public class DepthFirstTraversal {

    public void dft(TreeNode node, List<Integer> values) {

        if (node == null) {
            return;
        }

        values.add(node.getKey());
        dft(node.getLeft(), values);
        dft(node.getRight(), values);
    }
}
