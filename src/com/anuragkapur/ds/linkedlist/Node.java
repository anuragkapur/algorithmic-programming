package com.anuragkapur.ds.linkedlist;


/**
 * @author anuragkapur
 *
 */
public class Node {

	int key;
	Node next;
	Node previous;
	
	public Node(int key, Node next, Node previous) {
		this.key = key;
		this.next = next;
		this.previous = previous;
	}

    public Node(int key) {
        this.key = key;
    }
}
