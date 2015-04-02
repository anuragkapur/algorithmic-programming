package com.anuragkapur.ds.tree;

/**
 * @author anuragkapur
 */
public class BSTSearch {

    /**
     * Running time: O(h) = O(log n), where h is height of tree and n is the number of nodes in the tree
     *
     * @param searchKey
     * @param rootNode
     * @return
     */
    public TreeNode search(int searchKey, TreeNode rootNode) {

        if (rootNode == null || rootNode.getKey() == searchKey) {
            return rootNode;
        } else if (rootNode.getKey() > searchKey) {
            return search(searchKey, rootNode.getLeft());
        } else {
            return search(searchKey, rootNode.getRight());
        }
    }
}
