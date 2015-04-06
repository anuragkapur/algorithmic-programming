package com.anuragkapur.ds.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author anuragkapur
 */
public class TopologicalSort {

    private List<Vertex> sortedVertices = new ArrayList<>();
    private Set<Vertex> visited = new HashSet<>();


    public List<Vertex> computeTopologicalSort(Graph graph) {

        for (Vertex u : graph.getVertices()) {
            if (visited.add(u)) {
                // unexplored
                dfs(graph, u);
                sortedVertices.add(u);
            }
        }

        return sortedVertices;
    }

    public void dfs(Graph graph, Vertex u) {

        for(Edge edge : graph.getEdgesFrom(u)) {
            if (visited.add(edge.getVertex2())) {
                dfs(graph, edge.getVertex2());
                sortedVertices.add(edge.getVertex2());
            }
        }
    }
}
