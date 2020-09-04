package com.anuragkapur.ib.stacksnqueues;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingCharacterStream {
    public String solve(String A) {

        char[] chs = A.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> q = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<chs.length; i++) {
            upsertToMap(map, chs[i]);
            if (q.isEmpty()) {
                q.add(chs[i]);
            } else if (q.peek() == chs[i]) {
                q.remove();
            } else {
                q.add(chs[i]);
            }

            while (!q.isEmpty()) {
                char ch = q.peek();
                if (map.get(ch) > 1) {
                    q.remove();
                } else {
                    break;
                }
            }

            if (q.isEmpty()) {
                builder.append('#');
            } else {
                builder.append(q.peek());
            }
        }
        return builder.toString();
    }

    private void upsertToMap(Map<Character, Integer> map, char ch) {
        if (map.containsKey(ch)) {
            int count = map.get(ch);
            count ++;
            map.put(ch, count);
        } else {
            map.put(ch, 1);
        }
    }
}
