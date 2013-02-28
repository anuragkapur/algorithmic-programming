package com.anuragkapur.ds.linkedlist;

/**
 * Status: INCOMPLETE
 * 
 * @author anuragkapur
 */
public class InfiniteLoopDetector {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Creating a 5 node singly linked list with an infinite loop
		Node node5 = new Node("node 5", null);
		Node node4 = new Node("node 4", node5);
		Node node3 = new Node("node 3", node4);
		Node node2 = new Node("node 2", node3);
		Node node1 = new Node("node 1", node2);

		node5.next = node1;

		Node node = node1;
		Object firstNode = node;
		while (node.next != null) {
			System.out.println(node.value);
			if(node.next == firstNode) {
				break;
			}
			node = node.next;
		}
	}
}