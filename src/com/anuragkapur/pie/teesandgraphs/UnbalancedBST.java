package com.anuragkapur.pie.teesandgraphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author anuragkapur
 */
public class UnbalancedBST {

    public Node<Integer> balance(Node<Integer> root) {

        List<Node<Integer>> nodeList = getNodeList(root);

        if (nodeList == null) {
            return null;
        }

        Collections.sort(nodeList, new Comparator<Node<Integer>>() {
            @Override
            public int compare(Node<Integer> o1, Node<Integer> o2) {
                if (o1.getData().equals(o2.getData())) {
                    return 0;
                }
                return o1.getData() < o2.getData() ? -1 : 1;
            }
        });

        return convertToBalancedBST(nodeList, 0, nodeList.size()-1);
    }

    private  Node<Integer> convertToBalancedBST(List<Node<Integer>> nodeList, int start, int end) {

        if (start == end) {
            return nodeList.get(start);
        } else if(end - start == 1) {
            Node<Integer> root = nodeList.get(start);
            Node<Integer> child = nodeList.get(end);
            root.setLeft(child);
            return root;
        } else if(end - start == 2) {
            Node<Integer> root = nodeList.get(start + 1);
            Node<Integer> leftChild = nodeList.get(start);
            Node<Integer> rightChild = nodeList.get(end);
            root.setLeft(leftChild);
            root.setRight(rightChild);
            return root;
        } else {
            int medianIndex = ((end - start) / 2 ) + start;
            Node<Integer> root = nodeList.get(medianIndex);
            Node<Integer> leftSubRoot = convertToBalancedBST(nodeList, start, medianIndex-1);
            Node<Integer> rightSubRoot = convertToBalancedBST(nodeList, medianIndex+1, end);
            root.setLeft(leftSubRoot);
            root.setRight(rightSubRoot);
            return root;
        }
    }

    private List<Node<Integer>> getNodeList(Node<Integer> root) {
        return preorder(root, null);
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
