package com.anuragkapur.pie.arraysandstrings;

/**
 * @author anuragkapur
 */
public class ReverseWords {

    public String reverse(String str) {

        char ch[] = str.toCharArray();
        int start = 0;
        int end = str.length() - 1;

        // reverse string
        reverse(ch, start, end);

        // reverse words
        start = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                reverse(ch, start, i - 1);
                start = i+1;
            }
        }

        // reverse last word
        reverse(ch, start, ch.length-1);

        return new String(ch);
    }

    private void reverse(char[] ch, int start, int end) {
        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;

            start ++;
            end --;
        }
    }
}
