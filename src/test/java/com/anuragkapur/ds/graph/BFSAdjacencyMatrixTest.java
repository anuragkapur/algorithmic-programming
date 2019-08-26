package com.anuragkapur.ds.graph;

import org.junit.Assert;
import org.junit.Test;

public class BFSAdjacencyMatrixTest {

    @Test
    public void testPrintNodesInBFSOrder() throws Exception {

        /*
        Graph:
        0--1     4
        | / \   / \
        |/   \ /   \
        3-----2-----5
         */

        int graph[][] = new int[6][6];
        graph[0][1] = 1;
        graph[0][3] = 1;
        graph[1][0] = 1;
        graph[1][2] = 1;
        graph[1][3] = 1;
        graph[2][1] = 1;
        graph[2][3] = 1;
        graph[2][4] = 1;
        graph[3][0] = 1;
        graph[3][1] = 1;
        graph[3][2] = 1;
        graph[4][2] = 1;
        graph[4][5] = 1;
        graph[5][2] = 1;
        graph[5][4] = 1;

        BFSAdjacencyMatrix obj = new BFSAdjacencyMatrix();
        int result[] = obj.printNodesInBFSOrder(graph, 0);
        int expected[] = {0,1,3,2,4,5};
        Assert.assertArrayEquals(expected, result);
    }
}