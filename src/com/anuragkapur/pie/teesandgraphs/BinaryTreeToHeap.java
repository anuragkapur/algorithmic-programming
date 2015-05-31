package com.anuragkapur.pie.teesandgraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author anuragkapur
 */
public class BinaryTreeToHeap {

    public Node<Integer> convert(Node<Integer> root) {

        Node<Integer> nodes[] = getNodesArray(root);

        // sort in descending order
        Arrays.sort(nodes, new Comparator<Node<Integer>>() {
            @Override
            public int compare(Node<Integer> o1, Node<Integer> o2) {
                if (o1.getData() < o2.getData())
                    return 1;
                else if (o1.getData() > o2.getData())
                    return -1;
                else return 0;
            }
        });

        return getBinaryTreeBackedHeap(nodes);
    }

    private Node<Integer> getBinaryTreeBackedHeap(Node<Integer>[] nodes) {

        if (nodes == null) {
            return null;
        }

        for (int i = 0; i < nodes.length; i++) {
            Node<Integer> node = nodes[i];
            if (2*i+1 < nodes.length) {
                node.setLeft(nodes[2*i+1]);
            }
            if (2*i+2 < nodes.length) {
                node.setRight(nodes[2*i+2]);
            }
        }
        return nodes[0];
    }

    private Node<Integer>[] getNodesArray(Node<Integer> root) {

        List<Node<Integer>> nodeList = preorder(root, null);
        Node<Integer>[] nodes = new Node[nodeList.size()];
        nodeList.toArray(nodes);

        return nodes;
    }

    private List<Node<Integer>> preorder(Node<Integer> root, List<Node<Integer>> nodeList) {

        if (root != null) {
            if (nodeList == null) {
                nodeList = new ArrayList<>();
            }

            nodeList.add(root);
            preorder(root.getLeft(), nodeList);
            preorder(root.getRight(), nodeList);

            root.setLeft(null);
            root.setRight(null);
        }

        return nodeList;
    }
}
