package com.anuragkapur.leetcode.meta2023;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorIII_1650 {

    /**
     * Runtime Complexity: O(h), where h is height of tree
     * Space Complexity: O(h)
     * Leetcode Status: Accepted; Runtime: 29ms; Beats 42.24% of users with Java
     */
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Integer> nodesToRoot = new HashSet<>();
        Node current = p;
        while (current != null) {
            nodesToRoot.add(current.val);
            current = current.parent;
        }
        current = q;
        while (current != null) {
            if (!nodesToRoot.add(current.val)) {
                return current;
            } else {
                current = current.parent;
            }
        }

        throw new RuntimeException("algo logic wrong");
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };
}
