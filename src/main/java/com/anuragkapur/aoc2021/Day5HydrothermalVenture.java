package com.anuragkapur.aoc2021;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day5HydrothermalVenture {

    private static int[][] diagram = new int[1000][1000];
    private static int countOfAtLeast2;

    public static void main(String[] args) throws IOException {
        List<String> inputLines = AOC2021Util.getFileLines("com.anuragkapur.aoc2021/day5_hydrothermalventure.in");
        List<Line> lines = new ArrayList<>();
        for (String input : inputLines) {
            lines.add(getLineFromInput(input));
        }
        part1(lines); // 6564
        part2(lines); // 19172
    }

    private static void part1(List<Line> lines) {
        for (Line line : lines) {
            if (line.type.equals(Type.Horizontal)) {
                for (int x = line.fromX; x <= line.toX ; x++) {
                    diagram[x][line.fromY] ++;
                    countOfAtLeast2 = diagram[x][line.fromY] == 2 ? countOfAtLeast2 + 1 : countOfAtLeast2;
                }
            } else if (line.type.equals(Type.Vertical)) {
                for (int y = line.fromY; y <= line.toY; y++) {
                    diagram[line.fromX][y]++;
                    countOfAtLeast2 = diagram[line.fromX][y] == 2 ? countOfAtLeast2 + 1 : countOfAtLeast2;
                }
            }
        }
        System.out.println(countOfAtLeast2);
    }

    private static void part2(List<Line> lines) {
        for (Line line : lines) {
            if (line.type.equals((Type.RightDiag))) {
                int y = line.fromY;
                for (int x = line.fromX; x <= line.toX ; x++) {
                    diagram[x][y] ++;
                    countOfAtLeast2 = diagram[x][y] == 2 ? countOfAtLeast2 + 1 : countOfAtLeast2;
                    y ++;
                }
            } else if (line.type.equals(Type.LeftDiag)){
                int y = line.fromY;
                for (int x = line.fromX; x >= line.toX ; x--) {
                    diagram[x][y] ++;
                    countOfAtLeast2 = diagram[x][y] == 2 ? countOfAtLeast2 + 1 : countOfAtLeast2;
                    y ++;
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
                line.setLineCoordinates(x2, x1, y2, y1);
            } else {
                line.setLineCoordinates(x1, x2, y1, y2);
            }
        } else if (y1 == y2) {
            line.type = Type.Horizontal;
            if (x1 > x2) {
                line.setLineCoordinates(x2, x1, y2, y1);
            } else {
                line.setLineCoordinates(x1, x2, y1, y2);
            }
        } else if ((x1 > x2 && y1 > y2) || (x1 < x2 && y1 < y2)){
            line.type = Type.RightDiag;
            if (x1 < x2) {
                line.setLineCoordinates(x1, x2, y1, y2);
            } else {
                line.setLineCoordinates(x2, x1, y2, y1);
            }
        } else {
            line.type = Type.LeftDiag;
            if (x1 > x2) {
                line.setLineCoordinates(x1, x2, y1, y2);
            } else {
                line.setLineCoordinates(x2, x1, y2, y1);
            }
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
    void setLineCoordinates(int fromX, int toX, int fromY, int toY) {
        this.fromX = fromX;
        this.toX = toX;
        this.fromY = fromY;
        this.toY = toY;
    }
}

enum Type {
    Horizontal,
    Vertical,
    RightDiag,
    LeftDiag,
}