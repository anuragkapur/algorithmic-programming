package com.anuragkapur.aoc2021;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day10SyntaxScoring {
    public static void main(String[] args) throws IOException {
        List<String> inputLines = AOC2021Util.getFileLines("com.anuragkapur.aoc2021/day10_syntaxscoring.in");
        part1(inputLines);
    }

    private static void part1(List<String> inputLines) {
        List<Character> illegalChars = new ArrayList<>();
        for (String inputLine : inputLines) {
            Stack<Character> charStack = new Stack<>();
            for (int i = 0; i < inputLine.length(); i++) {
                char character = inputLine.charAt(i);
                switch (character) {
                    case '(':

                    case '[':

                    case '{':

                    case '<':
                        charStack.push(character);
                        break;

                    case ')': {
                        checkLegality(charStack, '(', illegalChars, character);
                        break;
                    }
                    case ']': {
                        checkLegality(charStack, '[', illegalChars, character);
                        break;
                    }
                    case '}': {
                        checkLegality(charStack, '{', illegalChars, character);
                        break;
                    }
                    case '>': {
                        checkLegality(charStack, '<', illegalChars, character);
                        break;
                    }
                }
            }
        }
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
        System.out.println(totalErrorScore);
    }

    private static void checkLegality(Stack<Character> charStack, char expectedChar, List<Character> illegalChars, char character) {
        char top = charStack.pop();
        if (top != expectedChar) {
            illegalChars.add(character);
        }
    }
}
