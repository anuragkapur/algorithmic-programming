package com.anuragkapur.misc;

/**
 * Rod cutting problem - Solution using DP - Top down with memoization
 * 
 * @author anuragkapur
 */
public class RodCutting1 {

	private static int prices[] = {1,5,8,9,10,17,17,20,24,30};
	private static int cuts[] = new int[prices.length];
	private static int optimalPrices[] = new int[prices.length];
	
	private static int rodCut(int length) {
		
		if(optimalPrices[length] != 0) {
			return optimalPrices[length];
		}
		
		System.out.println("rodCut :: " + length);
		
		int bestPrice = prices[length - 1];
		cuts[length - 1] = length;
		
		if(length == 1) {
			return prices[0];
		}
		
		for(int i=1; i< length - 1; i++) {
			int firstCutPrice = prices[i-1];
			int leftOverRodPrice = rodCut(length - i);
			int totalPrice = firstCutPrice + leftOverRodPrice;
			if(totalPrice > bestPrice) {
				bestPrice = totalPrice;
				cuts[length - 1] = i;
			}
		}
		
		optimalPrices[length] = bestPrice;
		
		return bestPrice;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int rodLength = 7;
		
		System.out.println(rodCut(rodLength));
		
		int length = rodLength;
		while (length > 0) {
			System.out.println(length);
			length -= cuts[length - 1];
		}
	}
}