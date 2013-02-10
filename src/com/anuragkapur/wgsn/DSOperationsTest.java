/**
 * 
 */
package com.anuragkapur.wgsn;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author anuragkapur
 *
 */
public class DSOperationsTest {

	/**
	 * Test method for {@link com.anuragkapur.wgsn.DSOperations#print(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testPrint() {
		
		String output = DSOperations.print("FIFO", "1,2,3,4,5,6,7,8,9");
		assertEquals(output, "1,2,3,4,5,6,7,8,9");
		
		output = DSOperations.print("FILO", "1,2,3,4,5,6,7,8,9");
		assertEquals(output, "9,8,7,6,5,4,3,2,1");
		
		output = DSOperations.print("FIFO", "3,5,1,3,7,8,9,6");
		assertEquals(output, "3,5,1,3,7,8,9,6");

		output = DSOperations.print("FILO", "3,5,1,3,7,8,9,6");
		assertEquals(output, "6,9,8,7,3,1,5,3");		
	}

	/**
	 * Test method for {@link com.anuragkapur.wgsn.DSOperations#printSort(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testPrintSort() {
		String output = DSOperations.printSort("FIFO", "1,2,3,4,5,6,7,8,9");
		assertEquals(output, "1,2,3,4,5,6,7,8,9");
		
		output = DSOperations.printSort("FIFO", "9,8,7,6,5,4,3,2,1");
		assertEquals(output, "1,2,3,4,5,6,7,8,9");
		
		output = DSOperations.printSort("FILO", "9,8,7,6,5,4,3,2,1");
		assertEquals(output, "9,8,7,6,5,4,3,2,1");
		
		output = DSOperations.printSort("FIFO", "9,8,7,6,5,4,3,2,1");
		assertEquals(output, "1,2,3,4,5,6,7,8,9");
		
		output = DSOperations.printSort("FILO", "3,5,1,3,7,8,9,6");
		assertEquals(output, "9,8,7,6,5,3,3,1");
		
		output = DSOperations.printSort("FIFO", "3,5,1,3,7,8,9,6");
		assertEquals(output, "1,3,3,5,6,7,8,9");
	}

}
