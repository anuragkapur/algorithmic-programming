package com.anuragkapur.ds.tree;

/**
 * @author anuragkapur
 */
public class BSTSearch {

    public TreeNode search(int searchKey, TreeNode rootNode) {

        if (rootNode == null) {
            return null;
        }

        if (rootNode.getKey() == searchKey) {
            return rootNode;
        } else if (rootNode.getKey() > searchKey) {
            return search(searchKey, rootNode.getLeft());
        } else {
            return search(searchKey, rootNode.getRight());
        }
    }
}
