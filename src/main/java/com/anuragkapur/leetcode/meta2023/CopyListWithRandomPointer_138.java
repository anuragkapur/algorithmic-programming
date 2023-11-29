package com.anuragkapur.leetcode.meta2023;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer_138 {

    /**
     * Runtime Complexity: O(n)
     * Space Complexity: O(n)
     * Leetcode Status: Accepted; Runtime: 0ms; Beats 100% of users with Java; Memory: Beats 25.49% of users with Java
     */
    public Node copyRandomList(Node head) {

        Map<Node, Node> newNodes = new HashMap<>();

        Node current = head;
        while (current != null) {
            newNodes.put(current, new Node(current.val, current.next, current.random));
            current = current.next;
        }

        current = head;
        while (current != null) {
            newNodes.get(current).next = newNodes.get(current.next);
            newNodes.get(current).random = newNodes.get(current.random);
            current = current.next;
        }

        return newNodes.get(head);
    }

    public class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }
}
