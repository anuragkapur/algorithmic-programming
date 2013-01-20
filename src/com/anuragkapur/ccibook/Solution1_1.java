package com.anuragkapur.ccibook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author anurag.kapur
 */
public class Solution1_1 {

    public boolean checkIfAllCharsUnique(String str) {
        boolean allUnique = true;
        
        Map<Character,Character> characters = new HashMap<Character,Character>();
        for(int i=0; i<str.length(); i++) {
            Character character = new Character(str.charAt(i));
            if(characters.get(character) != null) {
                allUnique = false;
                break;        
            }else {
                characters.put(character,character);
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
