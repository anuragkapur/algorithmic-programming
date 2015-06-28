package com.anuragkapur.ctci.treeandgraphs;

import com.anuragkapur.ds.tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anuragkapur
 */
public class Prob4_9_AllPathsTotalTox {

    /**
     * Solution WIP - Need to properly handle mutability of list
     *
     * @param root
     * @param total
     * @return
     */
    public List<List<Integer>> allPaths(Node<Integer> root, int total) {

        List<List<Integer>> paths = new ArrayList<>();
        dfs(root, new ArrayList<>(), paths);

        List<List<Integer>> pathsWithSumX = new ArrayList<>();
        for (List<Integer> path : paths) {
            for (int i=0; i<path.size(); i++) {
                int sum = 0;
                List<Integer> pathWithSumX = new ArrayList<>();
                for (int j=i; j<path.size(); j++) {
                    pathWithSumX.add(path.get(j));
                    sum += path.get(j);
                    if (sum == total) {
                        pathsWithSumX.add(pathWithSumX);
                    }
                }
            }
        }

        return pathsWithSumX;
    }

    private void dfs(Node<Integer> root, List<Integer> path, List<List<Integer>> paths) {

        if (root == null) {
            return;
        }

        path.add(root.getData());

        if (root.getLeft() == null && root.getRight() == null) {
            paths.add(path);
            return;
        }

        List<Integer> leftPath = new ArrayList<>();
        leftPath.addAll(path);
        List<Integer> rightPath = new ArrayList<>();
        rightPath.addAll(path);

        dfs(root.getLeft(), leftPath, paths);
        dfs(root.getRight(), rightPath, paths);
    }
}
