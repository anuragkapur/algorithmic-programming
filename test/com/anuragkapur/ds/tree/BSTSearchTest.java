package com.anuragkapur.ds.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author anuragkapur
 */
public class BSTSearchTest {

    BSTSearch bstSearch;

    @Before
    public void init() {
        bstSearch = new BSTSearch();
    }

    @Test
    public void testSearch1() throws Exception {
        TreeNode rootNode = TreeFactory.getBinarySearchTree();
        assertEquals(3, bstSearch.search(3, rootNode).getKey());
    }

    @Test
    public void testSearch2() throws Exception {
        TreeNode rootNode = TreeFactory.getBinarySearchTree();
        assertEquals(2, bstSearch.search(2, rootNode).getKey());
    }

    @Test
    public void testSearch3() throws Exception {
        TreeNode rootNode = TreeFactory.getBinarySearchTree();
        assertEquals(9, bstSearch.search(9, rootNode).getKey());
    }

    @Test
    public void testSearch4() throws Exception {
        TreeNode rootNode = TreeFactory.getBinarySearchTree();
        assertEquals(null, bstSearch.search(99, rootNode));
    }
}