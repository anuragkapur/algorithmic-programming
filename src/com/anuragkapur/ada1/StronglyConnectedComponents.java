package com.anuragkapur.ada1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Compute SCCs
 * 
 * @author anuragkapur
 */
public class StronglyConnectedComponents {

	private static int noOfNodes = 875714;
	private static Set<Integer> vertices = new HashSet<Integer>();
	private static Map<Integer,List<Integer>> edges = new HashMap<Integer, List<Integer>>();
	private static Map<Integer,List<Integer>> reverseEdges = new HashMap<Integer, List<Integer>>();
	
	private static int finishTime = -1;
	private static int[] nodes = new int[noOfNodes + 1];
	private static int[] nodesSortedByFinishTime = new int[noOfNodes];
	private static int sccSize = 0;
	
	private static List<Integer> sccSizes = new ArrayList<Integer>();
	
	/**
	 * Computes the Graph DS consisting of Set of vertices and Map of egdes
	 * 
	 * @param line
	 */
	private static void computeVerticesAndEdges(String line) {
		StringTokenizer tokenizer = new StringTokenizer(line," ");
		Integer vertex1 = new Integer(tokenizer.nextToken());
		Integer vertex2 = new Integer(tokenizer.nextToken());
		vertices.add(vertex1);
		vertices.add(vertex2);
		
		List<Integer> nodesOfEdge = null;
		
		// populate edges
		nodesOfEdge = edges.get(vertex1);
		if(nodesOfEdge != null) {
			nodesOfEdge.add(vertex2);
		}else {
			nodesOfEdge = new ArrayList<Integer>();
			nodesOfEdge.add(vertex2);
			edges.put(vertex1, nodesOfEdge);
		}
		
		// populate reverse edges
		nodesOfEdge = null;
		nodesOfEdge = reverseEdges.get(vertex2);
		if(nodesOfEdge != null) {
			nodesOfEdge.add(vertex1);
		}else {
			nodesOfEdge = new ArrayList<Integer>();
			nodesOfEdge.add(vertex1);
			reverseEdges.put(vertex2, nodesOfEdge);
		}
	}
	
	/**
	 * DFS on G-reverse
	 * 
	 * @param startNode
	 */
	private static void dfsGRev(Integer startNode) {
		
		// mark node i as explored
		nodes[startNode.intValue()] = 1;
		
		// find edges with start node as tail and another node as head in G-rev
		List<Integer> heads = reverseEdges.get(startNode);
		if(heads != null) {
			Iterator<Integer> headsIterator = heads.iterator();
			while(headsIterator.hasNext()) {
				
				Integer head = (Integer)headsIterator.next();
				
				// ignore self loops
				if(head.intValue() == startNode.intValue()) {
					continue;
				}
				
				if(nodes[head.intValue()] == 0) {
					// node not already explored
					dfsGRev(head);
				}
			}
		}
		
		finishTime ++;
		nodesSortedByFinishTime[finishTime] = startNode.intValue();
	}
	
	/**
	 * Compute finishing times on G-Rev
	 */
	private static void computeFinishingTimesOnGRev() {
		
		// iterate over all vertices and compute DFS on G-rev
		for(int i=0; i<noOfNodes; i++) {
			if(nodes[i+1] == 0) {
				// node is unexplored
				dfsGRev(new Integer(i+1));
			}
		}
	}
	
	/**
	 * DFS on G
	 * 
	 * @param startNode
	 */
	private static void dfs(Integer startNode) {

		// increment SCC size
		sccSize ++;
		
		// mark node i as explored
		nodes[startNode.intValue()] = 1;
		
		// find edges with start node as tail and another node as head in G
		List<Integer> heads = edges.get(startNode);
		if(heads != null) {
			Iterator<Integer> headsIterator = heads.iterator();
			while(headsIterator.hasNext()) {
				
				Integer head = (Integer)headsIterator.next();
				
				// ignore self loops
				if(head.intValue() == startNode.intValue()) {
					continue;
				}
				
				if(nodes[head.intValue()] == 0) {
					// node not already explored
					dfs(head);
				}
			}
		}
	}
	
	/**
	 * Compute Strongly connected components on G
	 */
	private static void computeSCCs() {
		
		// reset all nodes to unexplored
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = 0;
		}
		
		// iterate over all vertices and compute DFS
		for (int i = nodesSortedByFinishTime.length-1; i >= 0; i--) {
			if(nodes[nodesSortedByFinishTime[i]] == 0) {
				// node is unexplored
				sccSize = 0;
				dfs(new Integer(nodesSortedByFinishTime[i]));
				//System.out.println("sccSize :: " + sccSize);
				sccSizes.add(new Integer(sccSize));
			}
		}
		
		int sccs[] = new int[sccSizes.size()];
		for (int i = 0; i < sccs.length; i++) {
			sccs[i] = sccSizes.get(i).intValue();
		}
		
		// sort them
		Arrays.sort(sccs);
		
		for (int i = 0; i < 5; i++) {
			if(sccs.length - 1 - i >= 0) {
				System.out.println(sccs[sccs.length - 1 - i]);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		File file = new File("src/com/anuragkapur/ada1/scc.txt");
		String line = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null) {
				computeVerticesAndEdges(line);
			}
			System.out.println("Input parsing and graph construction complete");
			computeFinishingTimesOnGRev();
			System.out.println("DFS round 1 complete");
			computeSCCs();
			System.out.println("DFS round 2 complete");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}