package com.anuragkapur.ctci;

import com.anuragkapur.ds.graph.Edge;
import com.anuragkapur.ds.graph.Graph;
import com.anuragkapur.ds.graph.GraphFactory;
import com.anuragkapur.ds.graph.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: anuragkapur
 * @since: 09/05/2014
 */

public class Prob4_2_FindRouteDirectedGraph {

    public static List<Vertex> visited = new ArrayList<>();

    public static boolean isThereARoute(Graph g, Vertex start, Vertex end) {

        visited.add(start);

        if(start.equals(end))
            return true;

        for(Edge e : g.getEdgesFrom(start)) {

            Vertex v = e.getVertex2();
            if (visited.contains(v))
                continue;

            boolean isThereARoute = isThereARoute(g, v, end);

            if(isThereARoute) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Graph g = GraphFactory.getDirectedAcyclicGraph();
        Vertex start = new Vertex(1);
        Vertex end = new Vertex(4);
        System.out.println("Expected :: true :: Actual ::" + isThereARoute(g, start, end));

        g = GraphFactory.getDirectedCyclicGraph();
        visited = new ArrayList<>();
        start = new Vertex(1);
        end = new Vertex(4);
        System.out.println("Expected :: true :: Actual ::" + isThereARoute(g, start, end));

        end = new Vertex(5);
        visited = new ArrayList<>();
        System.out.println("Expected :: false :: Actual ::" + isThereARoute(g, start, end));
    }
}
