package com.anuragkapur.misc;

/**
 * Print all permutations of a given string. 
 * Note: substrings are not permutations
 * 
 * @author anurag.kapur
 */
public class StringPermute {

	public static int count = 0;
	
	public static void permute(String soFar, String strLeft) {
		
		if(strLeft.length() == 1) {
			soFar += strLeft;
			System.out.println(++count + " :: " + soFar);
		}
		
		for(int i=0; i<strLeft.length(); i++) {
			permute(soFar + strLeft.charAt(i), strLeft.substring(0,i) + strLeft.substring(i+1));
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "abcd";
		permute("",input);
	}
}