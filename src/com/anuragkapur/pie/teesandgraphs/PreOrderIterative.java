package com.anuragkapur.pie.teesandgraphs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author anuragkapur
 */
public class PreorderIterative {

    public List<Integer> preorder(Node<Integer> root) {

        List<Integer> result = new LinkedList<>();

        Deque<Node<Integer>> deque = new LinkedList<>();
        add(deque, root);
        while (!deque.isEmpty()) {
            Node<Integer> node = deque.pollFirst();
            result.add(node.getData());
            add(deque, node.getRight());
            add(deque, node.getLeft());
        }

        return result;
    }

    private void add(Deque<Node<Integer>> deque, Node<Integer> node) {
        if (node != null) {
            deque.addFirst(node);
        }
    }
}
