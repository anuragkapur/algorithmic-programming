package com.anuragkapur.misc;

/**
 * Rod cutting problem - Solution using DP - Top down with memoization
 * 
 * Status: INCOMPLETE
 * 
 * @author anuragkapur
 */
public class RodCutting1 {

	private static int prices[] = {1,5,8,9,10,17,17,20,24,30};
	
	private static int rodCut(int length) {
		
		int bestPrice = prices[length - 1];
		
		if(length == 1) {
			return prices[0];
		}
		
		for(int i=1; i< length - 1; i++) {
			int firstCutPrice = prices[i-1];
			int leftOverRodPrice = rodCut(length - i);
			int totalPrice = firstCutPrice + leftOverRodPrice;
			if(totalPrice > bestPrice) {
				bestPrice = totalPrice;
			}
		}
		
		return bestPrice;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(rodCut(prices.length));
		System.out.println(rodCut(7));
	}
}