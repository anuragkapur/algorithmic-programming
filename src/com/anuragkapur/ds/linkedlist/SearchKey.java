package com.anuragkapur.ds.linkedlist;

/**
 * @author anuragkapur
 *
 */
public class SearchKey {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node node1 = new Node(1, null, null);
		Node node2 = new Node(2, null, null);
		Node node3 = new Node(3, null, null);
		Node node4 = new Node(4, null, null);
		Node node5 = new Node(5, null, null);
		
		node5.previous = node4;
		node4.next = node5;
		node4.previous = node3;
		node3.next = node4;
		node3.previous = node2;
		node2.next = node3;
		node2.previous = node1;
		node1.next = node2;
		
		Node head = node1;
		
		// search for key 3
		Node x = head;
		while (x != null && x.key != 3) {
			System.out.println(x.key);
			x = x.next;
		}
		
		System.out.println("FOUND ::" + x.key);
	}
}