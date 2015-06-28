package com.anuragkapur.pie.teesandgraphs;

import com.anuragkapur.ds.tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anuragkapur
 */
public class Inorder {

    public List<Integer> inorder(Node<Integer> root) {
        return inorder(root, null);
    }

    private List<Integer> inorder(Node<Integer> root, List<Integer> result) {
        if (root != null) {
            if (result == null) {
                result = new ArrayList<>();
            }

            inorder(root.getLeft(), result);
            result.add(root.getData());
            inorder(root.getRight(), result);
        }

        return result;
    }
}
