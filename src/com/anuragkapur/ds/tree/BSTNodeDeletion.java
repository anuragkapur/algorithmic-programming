package com.anuragkapur.ds.tree;

/**
 * @author anuragkapur
 */
public class BSTNodeDeletion {

    private BSTSuccessorAndPredecessor successorAndPredecessor = new BSTSuccessorAndPredecessor();

    /**
     * TODO: Complete implementation and test
     *
     * @param nodeToDelete
     */
    public TreeNode deleteNode(TreeNode rootNode, TreeNode nodeToDelete) {

        if (nodeToDelete.getLeft() == null) {
            return replaceParentsChild(rootNode, nodeToDelete, nodeToDelete.getRight());
        } else if (nodeToDelete.getRight() == null) {
            return replaceParentsChild(rootNode, nodeToDelete, nodeToDelete.getLeft());
        } else {
            TreeNode successor = successorAndPredecessor.getSuccessor(nodeToDelete);
            if (successor.getRight() == null) {
                successor.setLeft(nodeToDelete.getLeft());
                successor.setRight(nodeToDelete.getRight());
                return replaceParentsChild(rootNode, nodeToDelete, successor);
            } else {
                replaceParentsChild(rootNode, successor, successor.getRight());
                successor.setLeft(nodeToDelete.getLeft());
                successor.setRight(nodeToDelete.getRight());
                return replaceParentsChild(rootNode, nodeToDelete, successor);
            }
        }
    }

    private TreeNode replaceParentsChild(TreeNode rootNode, TreeNode nodeToReplace, TreeNode nodeToReplaceWith) {

        if (nodeToReplace.getParent() == null) {
            return nodeToReplaceWith;
        }

        if (nodeToReplace.getParent().getLeft() == nodeToReplace) {
            nodeToReplace.getParent().setLeft(nodeToReplaceWith);
        } else {
            nodeToReplace.getParent().setRight(nodeToReplaceWith);
        }

        if (nodeToReplaceWith != null)
            nodeToReplaceWith.setParent(nodeToReplace.getParent());

        return rootNode;

    }
}
