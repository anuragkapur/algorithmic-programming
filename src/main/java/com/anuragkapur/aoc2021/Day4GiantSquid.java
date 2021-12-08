package com.anuragkapur.aoc2021;

import java.io.IOException;
import java.util.*;

public class Day4GiantSquid {

    private static Map<Integer, List<String>> numberToRowOrColumns = new HashMap<>();
    private static Map<String, Integer> rowOrColumnToUnmarkedCount = new HashMap<>();
    private static Map<String, List<Integer>> rowOrColumnToUnmarkedNumbers = new HashMap<>();
    private static Map<Integer, List<String>> unmarkedCountToRowOrColumn = new HashMap<>();

    public static void main(String[] args) throws IOException {
        List<String> lines = AOC2021Util.getFileLines("com.anuragkapur.aoc2021/day4_giantsquid.in");
        part1(lines); // 12796
    }

    private static void part1(List<String> lines) {
        processInputAndPopulateDataStructures(lines);
        String line1 = lines.get(0);
        String[] tokens = line1.split(",");
        for (String token: tokens) {
            int num = Integer.parseInt(token);
            List<String> rowsAndColumnsWithNum = numberToRowOrColumns.get(num);
            for (String rowOrColumnId : rowsAndColumnsWithNum) {
                int unmarkedCount = rowOrColumnToUnmarkedCount.get(rowOrColumnId);
                rowOrColumnToUnmarkedCount.put(rowOrColumnId, unmarkedCount-1);
                List<Integer> unmarkedNumbers = rowOrColumnToUnmarkedNumbers.get(rowOrColumnId);
                unmarkedNumbers.remove((Integer) num);
                if (unmarkedCountToRowOrColumn.containsKey(unmarkedCount-1)) {
                    unmarkedCountToRowOrColumn.get(unmarkedCount-1).add(rowOrColumnId);
                } else {
                    unmarkedCountToRowOrColumn.put(unmarkedCount-1, new ArrayList<>(List.of(rowOrColumnId)));
                }
            }
            if (unmarkedCountToRowOrColumn.containsKey(0)) {
                int sumOfUnmarked = getSumOfAllUnmarkedInBoardWithRowOrColumn(unmarkedCountToRowOrColumn.get(0).get(0));
                System.out.println(sumOfUnmarked * num);
                break;
            }
        }
    }

    private static int getSumOfAllUnmarkedInBoardWithRowOrColumn(String rowOrColumnId) {
        int sum = 0;
        int rowNum = Integer.parseInt(rowOrColumnId.substring(1));
        for (int i = 0; i < 5; i++) {
            String rowId = "r"+ (rowNum - (rowNum % 5) + i);
            List<Integer> unmarkedNums = rowOrColumnToUnmarkedNumbers.get(rowId);
            for (int num : unmarkedNums) {
                sum += num;
            }
        }
        return sum;
    }

    private static void processInputAndPopulateDataStructures(List<String> lines) {
        int rowNum = 0;
        int colNum = 0;
        for (int i = 2; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.equals("")) {
                continue;
            }
            String[] tokens = line.split("\\s");
            for (String token : tokens) {
                if (token.equals("")) {
                    continue;
                }
                addNumToMaps(Integer.parseInt(token), "r"+rowNum);
                addNumToMaps(Integer.parseInt(token), "c"+colNum++);
            }
            rowNum ++;
            if (rowNum % 5 != 0) {
                colNum = colNum - 5;
            }
        }
    }

    private static void addNumToMaps(int num, String rowOrColumnId) {
        if (numberToRowOrColumns.containsKey(num)) {
            numberToRowOrColumns.get(num).add(rowOrColumnId);
        } else {
            numberToRowOrColumns.put(num, new ArrayList<>(List.of(rowOrColumnId)));
        }

        if (!rowOrColumnToUnmarkedCount.containsKey(rowOrColumnId)) {
            rowOrColumnToUnmarkedCount.put(rowOrColumnId, 5);
        }

        if (rowOrColumnToUnmarkedNumbers.containsKey(rowOrColumnId)) {
            rowOrColumnToUnmarkedNumbers.get(rowOrColumnId).add(num);
        } else {
            rowOrColumnToUnmarkedNumbers.put(rowOrColumnId, new ArrayList<>(List.of(num)));
        }

        if (unmarkedCountToRowOrColumn.containsKey(5)) {
            unmarkedCountToRowOrColumn.get(5).add(rowOrColumnId);
        } else {
            unmarkedCountToRowOrColumn.put(5, new ArrayList<>(List.of(rowOrColumnId)));
        }
    }
}
