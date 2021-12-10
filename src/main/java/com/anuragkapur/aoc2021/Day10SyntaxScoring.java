package com.anuragkapur.aoc2021;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Day10SyntaxScoring {

    private static List<BigInteger> completionScores = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        List<String> inputLines = AOC2021Util.getFileLines("com.anuragkapur.aoc2021/day10_syntaxscoring.in");
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
            if (!illegalCharFound && !charStack.empty()) {
                processIncompleteLine(charStack);
            }
        }
        System.out.println(getTotalErrorScore(illegalChars)); // 278475
        completionScores.sort(Comparator.naturalOrder());
        int middleIndex = completionScores.size() / 2;
        System.out.println(completionScores.get(middleIndex)); // 3015539998
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

    private static void processIncompleteLine(Stack<Character> charStack) {
        BigInteger totalScore = BigInteger.ZERO;
        while (!charStack.empty()) {
            char top = charStack.pop();
            totalScore = totalScore.multiply(BigInteger.valueOf(5));
            switch (top) {
                case '(':
                    totalScore = totalScore.add(BigInteger.ONE);
                    break;
                case '[':
                    totalScore = totalScore.add(BigInteger.TWO);
                    break;
                case '{':
                    totalScore = totalScore.add(BigInteger.valueOf(3));
                    break;
                case '<':
                    totalScore = totalScore.add(BigInteger.valueOf(4));
                    break;
            }
        }
        completionScores.add(totalScore);
    }

    private static boolean isLegal(Stack<Character> charStack, char expectedChar) {
        return charStack.pop() == expectedChar;
    }
}
