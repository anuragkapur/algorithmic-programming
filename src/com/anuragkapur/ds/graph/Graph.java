package com.anuragkapur.ds.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: anuragkapur
 * @since: 09/05/2014
 */

public class Graph {

    List<Vertex> vertices;
    List<Edge> edges;

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

    public List<Edge> getEdgesFrom(Vertex v) {

        List<Edge> edgesFromVertex = new ArrayList<>();

        for (Edge edge : this.edges) {
            if (edge.getVertex1().equals(v)) {
                edgesFromVertex.add(edge);
            }
        }

        return edgesFromVertex;
    }
}
