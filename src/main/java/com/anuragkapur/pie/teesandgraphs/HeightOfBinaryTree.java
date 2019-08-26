package com.anuragkapur.pie.teesandgraphs;

import com.anuragkapur.ds.tree.Node;

/**
 * @author anuragkapur
 */
public class HeightOfBinaryTree {

    public int getHeight(Node<Integer> root) {

        if (root == null || (root.getLeft() == null && root.getRight() == null)) {
            return 0;
        } else {
            int left = getHeight(root.getLeft());
            int right = getHeight(root.getRight());

            return Math.max(left, right) + 1;
        }
    }
}
