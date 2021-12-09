package com.anuragkapur.aoc2021;

import java.io.IOException;
import java.util.List;

public class Day5HydrothermalVenture {

    private static int[][] diagram = new int[1000][1000];
    private static int countOfAtLeast2;

    public static void main(String[] args) throws IOException {
        List<String> inputLines = AOC2021Util.getFileLines("com.anuragkapur.aoc2021/day5_hydrothermalventure.in");
        for (String input : inputLines) {
            Line line = getLineFromInput(input);
            if (line.type.equals(Type.Horizontal)) {
                for (int i = line.fromX; i <= line.toX ; i++) {
                    diagram[i][line.fromY] ++;
                    if (diagram[i][line.fromY] == 2) {
                        countOfAtLeast2 ++;
                    }
                }
            } else if (line.type.equals(Type.Vertical)){
                for (int i = line.fromY; i <= line.toY ; i++) {
                    diagram[line.fromX][i] ++;
                    if (diagram[line.fromX][i] == 2) {
                        countOfAtLeast2 ++;
                    }
                }
            }
        }
        System.out.println(countOfAtLeast2);
    }

    private static Line getLineFromInput(String input) {
        int x1, y1, x2, y2;
        String[] pointStrings = input.split("->");

        String[] coordinateStrings = pointStrings[0].split(",");
        x1 = Integer.parseInt(coordinateStrings[0].trim());
        y1 = Integer.parseInt(coordinateStrings[1].trim());

        coordinateStrings = pointStrings[1].split(",");
        x2 = Integer.parseInt(coordinateStrings[0].trim());
        y2 = Integer.parseInt(coordinateStrings[1].trim());

        Line line = new Line();

        if (x1 == x2) {
            line.type = Type.Vertical;
            if (y1 > y2) {
                line.fromY = y2;
                line.toY = y1;
                line.fromX = x2;
                line.toX = x1;
            } else {
                line.fromY = y1;
                line.toY = y2;
                line.fromX = x1;
                line.toX = x2;
            }
        } else if (y1 == y2) {
            line.type = Type.Horizontal;
            if (x1 > x2) {
                line.fromX = x2;
                line.toX = x1;
                line.fromY = y2;
                line.toY = y1;
            } else {
                line.fromX = x1;
                line.toX = x2;
                line.fromY = y1;
                line.toY = y2;
            }
        } else {
            line.type = Type.Other;
        }
        return line;
    }
}

class Line {
    Type type;
    int fromX;
    int fromY;
    int toX;
    int toY;
}

enum Type {
    Horizontal,
    Vertical,
    Other
}