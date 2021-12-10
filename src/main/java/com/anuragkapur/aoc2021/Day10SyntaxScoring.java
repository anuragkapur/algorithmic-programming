package com.anuragkapur.aoc2021;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day10SyntaxScoring {
    public static void main(String[] args) throws IOException {
        List<String> inputLines = AOC2021Util.getFileLines("com.anuragkapur.aoc2021/day10_syntaxscoring.in");
        part1(inputLines); // 278475
    }

    private static void part1(List<String> inputLines) {
        List<Character> illegalChars = new ArrayList<>();
        for (String inputLine : inputLines) {
            Stack<Character> charStack = new Stack<>();
            boolean illegalCharFound = false;
            for (int i = 0; i < inputLine.length(); i++) {
                char currentChar = inputLine.charAt(i);
                if (currentChar == '(' || currentChar == '[' || currentChar == '{' || currentChar == '<') {
                    charStack.push(currentChar);
                } else if (currentChar == ')') {
                    if (!isLegal(charStack, '(')) {
                        illegalCharFound = true;
                    }
                } else if (currentChar == ']') {
                    if (!isLegal(charStack, '[')) {
                        illegalCharFound = true;
                    }
                } else if (currentChar == '}') {
                    if (!isLegal(charStack, '{')) {
                        illegalCharFound = true;
                    }
                } else if (currentChar == '>') {
                    if (!isLegal(charStack, '<')) {
                        illegalCharFound = true;
                    }
                }
                if (illegalCharFound) {
                    illegalChars.add(currentChar);
                    break;
                }
            }
        }
        System.out.println(getTotalErrorScore(illegalChars));
    }

    private static int getTotalErrorScore(List<Character> illegalChars) {
        int totalErrorScore = 0;
        for (Character illegalChar : illegalChars) {
            switch (illegalChar) {
                case ')':
                    totalErrorScore += 3;
                    break;
                case ']':
                    totalErrorScore += 57;
                    break;
                case '}':
                    totalErrorScore += 1197;
                    break;
                case '>':
                    totalErrorScore += 25137;
                    break;
            }
        }
        return totalErrorScore;
    }

    private static boolean isLegal(Stack<Character> charStack, char expectedChar) {
        return charStack.pop() == expectedChar ? true : false;
    }
}
