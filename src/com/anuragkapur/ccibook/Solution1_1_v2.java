package com.anuragkapur.ccibook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @author anurag.kapur
 */
public class Solution1_1_v2 {

    public boolean checkIfAllCharsUnique(String str) {
        boolean allUnique = true;
        
        char[] characters = str.toCharArray();
        Arrays.sort(characters);
        
        for (int i = 0; i < characters.length - 1; i++) {
			if(characters[i] == characters[i+1]) {
				allUnique = false;
				break;
			}
		}
        return allUnique;
    }
    
    public static void main(String args[]) throws IOException {
    	System.out.println("Enter the string \"quit\" to exit");
    	
    	Solution1_1 solution = new Solution1_1();
        String str;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while((str = br.readLine()) != null) {
        	if(str.equalsIgnoreCase("quit")) {
        		break;
        	}
        	System.out.println("All characters unique in string? :: " + solution.checkIfAllCharsUnique(str));
        }
    }
}
