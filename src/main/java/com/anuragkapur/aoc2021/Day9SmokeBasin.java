package com.anuragkapur.aoc2021;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Day9SmokeBasin {

    static Set<Point> pointsAddedToABasin = new HashSet<>();
    static List<Point> lowPoints = new ArrayList<>();
    static Map<Point, Integer> lowPointToBasinSize = new HashMap<>();
    static int[][] heightMap;
    static int totalRows, totalColumns;

    public static void main(String[] args) throws IOException {
        List<String> lines = AOC2021Util.getFileLines("com.anuragkapur.aoc2021/day9_smokebasin.in");
        totalRows = lines.size();
        totalColumns = lines.get(0).length();
        heightMap = new int[totalRows][totalColumns];
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                heightMap[i][j] = Integer.parseInt(String.valueOf(lines.get(i).charAt(j)));
            }
        }
        part1(); // 489
        part2(); // 1056330
    }

    private static void part1() {
        List<Integer> riskLevels = new ArrayList<>();
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                int num = heightMap[i][j];
                int up = i-1;
                int down = i+1;
                int left = j-1;
                int right = j+1;
                if (inBounds(up, totalRows)) {
                    if (num >= heightMap[up][j]) {
                        continue;
                    }
                }
                if (inBounds(down, totalRows)) {
                    if (num >= heightMap[down][j]) {
                        continue;
                    }
                }
                if (inBounds(left, totalColumns)) {
                    if (num >= heightMap[i][left]) {
                        continue;
                    }
                }
                if (inBounds(right, totalColumns)) {
                    if (num >= heightMap[i][right]) {
                        continue;
                    }
                }
                lowPoints.add(new Point(i, j));
                riskLevels.add(num+1);
            }
        }
        System.out.println(riskLevels.stream().reduce(0, Integer::sum));
    }

    private static void part2() {
        lowPoints.forEach(point -> {
            lowPointToBasinSize.put(point, 1);
            search(point, point);
        });
        List<Integer> sortedSizes = lowPointToBasinSize.values().stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        int largest = sortedSizes.get(sortedSizes.size()-1);
        int secondLargest = sortedSizes.get(sortedSizes.size()-2);
        int thirdLargest = sortedSizes.get(sortedSizes.size()-3);
        System.out.println(largest * secondLargest * thirdLargest);
    }

    private static void search(Point basinCentrePoint, Point point) {

        int up = point.x - 1;
        int down = point.x + 1;
        int left = point.y - 1;
        int right = point.y + 1;
        int pointHeight = heightMap[point.x][point.y];

        if (inBounds(up, totalRows)) {
            Point adjacentPoint = new Point(up, point.y);
            int adjacentPointHeight = heightMap[adjacentPoint.x][adjacentPoint.y];
            checkAndSearch(basinCentrePoint, pointHeight, adjacentPoint, adjacentPointHeight);
        }

        if (inBounds(down, totalRows)) {
            Point adjacentPoint = new Point(down, point.y);
            int adjacentPointHeight = heightMap[adjacentPoint.x][adjacentPoint.y];
            checkAndSearch(basinCentrePoint, pointHeight, adjacentPoint, adjacentPointHeight);
        }

        if (inBounds(left, totalColumns)) {
            Point adjacentPoint = new Point(point.x, left);
            int adjacentPointHeight = heightMap[adjacentPoint.x][adjacentPoint.y];
            checkAndSearch(basinCentrePoint, pointHeight, adjacentPoint, adjacentPointHeight);
        }

        if (inBounds(right, totalColumns)) {
            Point adjacentPoint = new Point(point.x, right);
            int adjacentPointHeight = heightMap[adjacentPoint.x][adjacentPoint.y];
            checkAndSearch(basinCentrePoint, pointHeight, adjacentPoint, adjacentPointHeight);
        }
    }

    private static void checkAndSearch(Point basinCentrePoint, int pointHeight, Point adjacentPoint, int adjacentPointHeight) {
        if (adjacentPointHeight != 9 && adjacentPointHeight > pointHeight) {
            int currentSize = lowPointToBasinSize.get(basinCentrePoint);
            if (pointsAddedToABasin.add(adjacentPoint)) {
                lowPointToBasinSize.replace(basinCentrePoint, currentSize + 1);
                search(basinCentrePoint, adjacentPoint);
            }
        }
    }

    private static boolean inBounds(int x, int max) {
        return (x >= 0 && x < max);
    }

    @Data
    @AllArgsConstructor
    @EqualsAndHashCode
    private static class Point {
        int x;
        int y;
    }
}