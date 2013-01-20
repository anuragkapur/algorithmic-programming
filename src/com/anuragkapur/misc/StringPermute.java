/**
 * 
 */
package com.anuragkapur.misc;

/**
 * @author anurag.kapur
 *
 */
public class StringPermute {

	public static int count = 0;
	
	public static void permute(String soFar, String rest) {

		System.out.println(count ++);
		
		if(rest.equals("")) {
			System.out.println(soFar);
		}else {
			for(int i=0; i<rest.length(); i++) {
				String newSoFar = soFar + rest.charAt(i);
				String newRest = "";
				if(i == 0) {
					newRest = rest.substring(i+1);
				}else if(i == rest.length()) {
					newRest = rest.substring(0,i);
				}else {
					newRest = rest.substring(0,i) + rest.substring(i+1);
				}
				permute(newSoFar, newRest);
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "abcd";
		permute("", input);
	}
}