package com.anuragkapur.fb.hackercup2020.qr;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class TravelRestrictions {

    private static final String INPUT_DIR = "src/main/resources/com.anurgakapur.fb.hackercup2020.qr";
    private static final String INPUT_FILE = "travelrestrictions.in";
    private static final String OUTPUT_DIR = "src/main/resources/com.anurgakapur.fb.hackercup2020.qr";
    private static final String OUTPUT_FILE = "travelrestrictions.out";

    char[] ins;
    char[] outs;
    Map<Pair, Boolean> adjacentRoutes;

    private String[] compute(int n, String incomings, String outgoings) {
        String[] answer = new String[n];

        ins = incomings.toCharArray();
        outs = outgoings.toCharArray();
        adjacentRoutes = computeAdjacentRoutes(n);

        boolean[][] routes = new boolean[n][n];
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                if (i == j) {
                    routes[i][j] = true;
                } else {
                    Pair pair = new Pair(i, j);
                    if (adjacentRoutes.containsKey(pair)) {
                        routes[i][j] = adjacentRoutes.get(pair);
                    } else {
                        routes[i][j] = doesRouteExist(i, j);
                    }
                }
            }
        }

        for (int i = 0; i < routes.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < routes[i].length; j++) {
                if (routes[i][j]) {
                    builder.append('Y');
                } else {
                    builder.append('N');
                }
            }
            answer[i] = builder.toString();
        }

        return answer;
    }

    private Map<Pair, Boolean> computeAdjacentRoutes(int n) {

        Map<Pair, Boolean> adjacentRoutes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int from = i;
            int to = i+1;

            if (to < n) {
                boolean exists = doesRouteExistBetweenAdjacent(from, to);
                adjacentRoutes.put(new Pair(from, to), exists);
            }

            from = i;
            to = i-1;
            if (to >= 0) {
                boolean exists = doesRouteExistBetweenAdjacent(from, to);
                adjacentRoutes.put(new Pair(from, to), exists);
            }
        }
        return adjacentRoutes;
    }

    private boolean doesRouteExistBetweenAdjacent(int from, int to) {
        return outs[from] == 'Y' && ins[to] == 'Y';
    }

    private boolean doesRouteExist(int from, int to) {
        if (from < to) {
            int k = from;
            while(k < to) {
                if (!adjacentRoutes.get(new Pair(k, k+1))) {
                    return false;
                }
                k++;
            }
            return true;
        } else {
            int k = from;
            while(k > to) {
                if (!adjacentRoutes.get(new Pair(k, k-1))) {
                    return false;
                }
                k--;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(INPUT_DIR, INPUT_FILE));
            int caseCount = Integer.parseInt(lines.get(0));
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i <= caseCount; i++) {
                int start = (i-1)*3+1;
                int n = Integer.parseInt(lines.get(start));
                String incomings = lines.get(start+1);
                String outgoings = lines.get(start+2);
                TravelRestrictions t = new TravelRestrictions();
                String[] answer = t.compute(n, incomings, outgoings);
                builder.append("Case #").append(i).append(":");
                builder.append(System.lineSeparator());
                for (String s : answer) {
                    builder.append(s);
                    builder.append(System.lineSeparator());
                }
            }
            Files.write(Paths.get(OUTPUT_DIR, OUTPUT_FILE), builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Pair {
        int from;
        int to;

        public Pair(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return from == pair.from &&
                    to == pair.to;
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }
}