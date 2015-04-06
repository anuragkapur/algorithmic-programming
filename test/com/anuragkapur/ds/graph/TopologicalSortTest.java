package com.anuragkapur.ds.graph;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class TopologicalSortTest {

    @Test
    public void testComputeTopologicalSort() throws Exception {
        TopologicalSort topologicalSort = new TopologicalSort();
        List<Vertex> sorted = topologicalSort.computeTopologicalSort(GraphFactory.getDirectedAcyclicGraph());
        final String expected = "[Vertex{label=4}, Vertex{label=2}, Vertex{label=3}, Vertex{label=1}, Vertex{label=5}]";
        assertEquals(expected, sorted.toString());
    }
}