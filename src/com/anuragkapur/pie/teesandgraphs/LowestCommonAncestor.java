package com.anuragkapur.pie.teesandgraphs;

/**
 * @author anuragkapur
 */
public class LowestCommonAncestor {

    public Node<Integer> lca(Node<Integer> root, int a, int b) {

        int comparison = 0;

        // assumes all nodes <= (note the '=') lie in the left subtree
        comparison = (root.getData() < a) ? comparison + 1: comparison - 1;
        comparison = (root.getData() < b) ? comparison + 1: comparison - 1;

        if (comparison == 0) {
            return root;
        } else if(comparison > 0) {
            return lca(root.getRight(), a, b);
        } else {
            return lca(root.getLeft(), a, b);
        }
    }
}
