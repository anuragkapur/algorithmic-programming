package com.anuragkapur.ds.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: anuragkapur
 * @since: 09/05/2014
 */

public class GraphFactory {

    /**
     *      1----->2--------->4
     *      |     >           ^
     *      |    /            |
     *      |   /             |
     *      |  /              5
     *      > /
     *      3
     *
     * @return a directed acyclic graph
     */
    public static Graph getDirectedAcyclicGraph() {

        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);

        List<Vertex> vertices = new ArrayList<>(5);
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);

        Edge edge1 = new DirectedEdge(v1, v2);
        Edge edge2 = new DirectedEdge(v1, v3);
        Edge edge3 = new DirectedEdge(v3, v2);
        Edge edge4 = new DirectedEdge(v2, v4);
        Edge edge5 = new DirectedEdge(v5, v4);

        List<Edge> edges = new ArrayList<>(5);
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);
        edges.add(edge4);
        edges.add(edge5);

        Graph graph = new Graph();
        graph.setVertices(vertices);
        graph.setEdges(edges);

        return graph;
    }

    /**
     *           1----->2--------->4
     *           ^     /           ^
     *           |    /            |
     *           |   /             |
     *           |  /              5
     *           | <
     *           3
     *
     * @return a directed cyclic graph
     */
    public static Graph getDirectedCyclicGraph() {

        /*
            1----->2--------->4
            ^     /           ^
            |    /            |
            |   /             |
            |  /              5
            | <
            3
         */

        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);

        List<Vertex> vertices = new ArrayList<>(5);
        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);
        vertices.add(v4);
        vertices.add(v5);

        Edge edge1 = new DirectedEdge(v1, v2);
        Edge edge2 = new DirectedEdge(v2, v3);
        Edge edge3 = new DirectedEdge(v3, v1);
        Edge edge4 = new DirectedEdge(v2, v4);
        Edge edge5 = new DirectedEdge(v5, v4);

        List<Edge> edges = new ArrayList<>(5);
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);
        edges.add(edge4);
        edges.add(edge5);

        Graph graph = new Graph();
        graph.setVertices(vertices);
        graph.setEdges(edges);

        return graph;
    }

}
