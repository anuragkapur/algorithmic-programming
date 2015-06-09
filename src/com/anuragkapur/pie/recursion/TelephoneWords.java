package com.anuragkapur.pie.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anuragkapur
 */
public class TelephoneWords {

    public List<String> words(int a[]) {

        if (a == null || a.length == 0) {
            return null;
        }

        TeleponeWordsComputer teleponeWordsComputer = new TeleponeWordsComputer(a);
        teleponeWordsComputer.compute();
        return teleponeWordsComputer.words;
    }

    private class TeleponeWordsComputer {

        List<String> words;
        StringBuilder word;
        int a[];

        TeleponeWordsComputer(int a[]) {
            this.words = new ArrayList<>();
            word = new StringBuilder();
            this.a = a;
        }

        public void compute() {
            compute(0);
        }

        private void compute(int index) {

            if (word.length() == a.length) {
                words.add(word.toString());
            } else {
                int num = a[index];
                char chars[] = getChars(num);
                for (char ch : chars) {
                    word.append(String.valueOf(ch));
                    compute(index + 1);
                    word.setLength(word.length() - 1);
                }
            }
        }

        private char[] getChars(int num) {

            char chars[];

            switch (num) {
                case 0:
                    chars = new char[1];
                    chars[0] = '0';
                    break;
                case 1:
                    chars = new char[1];
                    chars[0] = '1';
                    break;
                default:
                    chars = new char[3];
                    chars[0] = getCharKey(num, 0);
                    chars[1] = getCharKey(num, 1);
                    chars[2] = getCharKey(num, 2);
                    break;
            }

            return chars;
        }

        private char getCharKey(int num, int i) {

            char ch;

            switch(num) {
                case 2:
                    if (i == 0) {
                        ch = 'A';
                    } else if (i == 1) {
                        ch = 'B';
                    } else {
                        ch = 'C';
                    }
                    break;
                case 3:
                    if (i == 0) {
                        ch = 'D';
                    } else if (i == 1) {
                        ch = 'E';
                    } else {
                        ch = 'F';
                    }
                    break;
                case 4:
                    if (i == 0) {
                        ch = 'G';
                    } else if (i == 1) {
                        ch = 'H';
                    } else {
                        ch = 'I';
                    }
                    break;
                case 5:
                    if (i == 0) {
                        ch = 'J';
                    } else if (i == 1) {
                        ch = 'K';
                    } else {
                        ch = 'L';
                    }
                    break;
                case 6:
                    if (i == 0) {
                        ch = 'M';
                    } else if (i == 1) {
                        ch = 'N';
                    } else {
                        ch = 'O';
                    }
                    break;
                case 7:
                    if (i == 0) {
                        ch = 'P';
                    } else if (i == 1) {
                        ch = 'R';
                    } else {
                        ch = 'S';
                    }
                    break;
                case 8:
                    if (i == 0) {
                        ch = 'T';
                    } else if (i == 1) {
                        ch = 'U';
                    } else {
                        ch = 'V';
                    }
                    break;
                case 9:
                    if (i == 0) {
                        ch = 'W';
                    } else if (i == 1) {
                        ch = 'X';
                    } else {
                        ch = 'Y';
                    }
                    break;
                default:
                    // undefined. this should never get executed
                    ch = '!';
                    throw new IllegalArgumentException("Invalid char");
            }

            return ch;
        }
    }
}
