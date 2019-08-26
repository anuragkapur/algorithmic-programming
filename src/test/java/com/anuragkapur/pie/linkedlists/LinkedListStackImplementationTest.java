package com.anuragkapur.pie.linkedlists;

import org.junit.Test;

import java.util.IntSummaryStatistics;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class LinkedListStackImplementationTest {

    @Test
    public void testPush() throws Exception {
        LinkedListStackImplementation<Integer> stack = new LinkedListStackImplementation<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals("3,2,1",stack.toString());
    }

    @Test
    public void testPop() throws Exception {
        LinkedListStackImplementation<Integer> stack = new LinkedListStackImplementation<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());
        assertEquals(null, stack.pop());
    }

    @Test
    public void testPopAndPush() throws Exception {
        LinkedListStackImplementation<Integer> stack = new LinkedListStackImplementation<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());
        assertEquals(null, stack.pop());
        assertEquals(null, stack.pop());
        stack.push(5);
        stack.push(4);
        assertEquals("4,5", stack.toString());
    }

    @Test
    public void testPeek() throws Exception {

    }

    @Test
    public void testSize() throws Exception {
        LinkedListStackImplementation<Integer> stack = new LinkedListStackImplementation<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.size());
        stack.peek();
        assertEquals(3, stack.size());
        stack.pop();
        assertEquals(2, stack.size());
        stack.pop();
        stack.pop();
        assertEquals(0, stack.size());
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        assertEquals(0, stack.size());

    }
}