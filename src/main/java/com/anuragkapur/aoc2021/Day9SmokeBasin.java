package com.anuragkapur.aoc2021;

import scala.Int;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day9SmokeBasin {

    static int[][] heightMap;
    static int rows, columns;

    public static void main(String[] args) throws IOException {
        List<String> lines = AOC2021Util.getFileLines("com.anuragkapur.aoc2021/day9_smokebasin.in");
        rows = lines.size();
        columns = lines.get(0).length();
        heightMap = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                heightMap[i][j] = Integer.parseInt(String.valueOf(lines.get(i).charAt(j)));
            }
        }
        part1();
    }

    private static void part1() {
        List<Integer> lowPoints = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int num = heightMap[i][j];
                int up = i-1;
                int down = i+1;
                int left = j-1;
                int right = j+1;
                if (inBounds(up, rows)) {
                    if (num >= heightMap[up][j]) {
                        continue;
                    }
                }
                if (inBounds(down, rows)) {
                    if (num >= heightMap[down][j]) {
                        continue;
                    }
                }
                if (inBounds(left, columns)) {
                    if (num >= heightMap[i][left]) {
                        continue;
                    }
                }
                if (inBounds(right, columns)) {
                    if (num >= heightMap[i][right]) {
                        continue;
                    }
                }
                lowPoints.add(num);
            }
        }
        System.out.println(lowPoints.stream().map(x -> x + 1).reduce(0, Integer::sum));
    }

    private static boolean inBounds(int x, int max) {
        return (x >= 0 && x < max);
    }
}
