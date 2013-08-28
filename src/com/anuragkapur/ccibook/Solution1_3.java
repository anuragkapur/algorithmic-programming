package com.anuragkapur.ccibook;

public class Solution1_3 {

    public String removeDuplicateCharacter(char[] str) {
        /*
        abcdbefgha12345
        */
        
        // TODO: Handle edge cases like string with 1 char or null strings
        
        char first = str[0];
        int pointer = 0;
        
        for(int i=1; i<str.length; i++) {
            boolean duplicateFound = false;
            
            for(int j=0; j<i; j++) {
                if(str[i] == str[j]) {
                    // This is a duplicate character.
                    duplicateFound = true;
                    break;
                }
            }

            if(!duplicateFound) {
                pointer ++;
                str[pointer] = str[i]; 
            }
        }
        
        // Cleanup string
        for(int i=pointer+1; i<str.length; i++) {
            str[i] = '\0';
        }
        
        return new String(str);
    }
    
    public static void main(String args[]) {
        Solution1_3 solution = new Solution1_3();
        String input = "abababa";
        System.out.println(solution.removeDuplicateCharacter(input.toCharArray()));
    }
}