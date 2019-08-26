package com.anuragkapur.ctci;

import com.anuragkapur.ds.tree.BreadthFirstTraversal;
import com.anuragkapur.ds.tree.TreeNode;

/**
 * @author: anuragkapur
 * @since: 09/05/2014
 */

public class Prob4_3_BSTWithMinHeight {

    public static TreeNode createBST(int a[], int startIndex, int endIndex) {
        if(a == null) {

            return null;

        } else if (endIndex - startIndex == 0){

            TreeNode node1 = new TreeNode(a[startIndex]);
            return node1;

        }else if(endIndex - startIndex == 1)  {

            TreeNode node1;

            if(a[startIndex] < a[endIndex]) {
                node1 = new TreeNode(a[startIndex]);
                TreeNode node2 = new TreeNode(a[endIndex]);
                node1.setRight(node2);
            } else {
                node1 = new TreeNode(a[startIndex]);
                TreeNode node2 = new TreeNode(a[endIndex]);
                node1.setLeft(node2);
            }

            return node1;

        } else {

            int middleIndex = (startIndex + endIndex) / 2;
            TreeNode node1 = new TreeNode(a[middleIndex]);
            TreeNode leftSubTree = createBST(a, startIndex, middleIndex - 1);
            TreeNode rightSubTree = createBST(a, middleIndex + 1, endIndex);

            node1.setLeft(leftSubTree);
            node1.setRight(rightSubTree);

            return node1;
        }
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8};
        TreeNode rootNode = createBST(a, 0, a.length - 1);
        BreadthFirstTraversal.breadthFirst(rootNode);
    }
}
