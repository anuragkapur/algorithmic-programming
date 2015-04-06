package com.anuragkapur.ds.tree;

/**
 * @author anuragkapur
 */
public class BSTSuccessor {

    BSTMinAndMax minAndMax = new BSTMinAndMax();

    public TreeNode getSuccessor(TreeNode givenNode) {

        if (givenNode == null) {
            return givenNode;
        }

        if (givenNode.getRight() != null) {
            return minAndMax.getMin(givenNode.getRight());
        } else {
            TreeNode ancestor = givenNode.getParent();
            while (ancestor != null && ancestor.getLeft() != givenNode) {
                givenNode = ancestor;
                ancestor = ancestor.getParent();
            }
            return ancestor;
        }
    }
}
