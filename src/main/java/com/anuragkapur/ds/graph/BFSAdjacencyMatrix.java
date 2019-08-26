package com.anuragkapur.ds.graph;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Traversal of graph using Breadth First Search oder. Graph represented using an adjacency matrix.
 *
 * Running time: O(V^2), where V is number of vertices in the graph.
 *
 * @author: anuragkapur
 */

public class BFSAdjacencyMatrix {

    public int[] printNodesInBFSOrder(int graph[][], int startingNode) {

        // to track visited nodes
        Set<Integer> visitedSet = new HashSet<>();

        Deque<Integer> queue = new LinkedList<>();
        queue.add(startingNode);
        visitedSet.add(startingNode);

        int result[] = new int[graph.length];
        int runner = 0;

        while (!queue.isEmpty()) {

            int current = queue.poll();
            result[runner ++] = current;

            for (int i=0; i<graph[current].length; i++) {
                // check if edge exists
                if (graph[current][i] == 1) {
                    // check if already visited
                    if (visitedSet.add(i)) {
                        queue.add(i);
                    }
                }
            }

        }

        return result;
    }
}
