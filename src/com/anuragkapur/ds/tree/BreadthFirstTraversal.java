package com.anuragkapur.ds.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: anuragkapur
 * @since: 09/05/2014
 */

public class BreadthFirstTraversal {

    public static void breadthFirst(TreeNode startingNode) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(startingNode);
        int count = 0;
        int level = 1;

        while(queue.peek() != null) {
            count ++;
            TreeNode currentNode = queue.poll();
            System.out.print(currentNode.getPayload());

            if ((count + 1) == Math.pow(2, level)) {
                level ++;
                System.out.println();
            }

            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }
    }
}
