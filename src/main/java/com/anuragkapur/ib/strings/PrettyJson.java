package com.anuragkapur.ib.strings;

import java.util.ArrayList;

public class PrettyJson {

    public ArrayList<String> prettyJSON(String A) {

        ArrayList<String> answer = new ArrayList<>();

        char[] chs = A.toCharArray();
        int indentLevel = 0;
        StringBuilder builder = new StringBuilder();

        for (int i=0; i<chs.length; i++) {
            if (chs[i] == '{' || chs[i] == '[') {
                collectBuilderAndAddToAnswer(answer, indentLevel, builder);
                builder = new StringBuilder(getIndentSpaces(indentLevel));
                builder.append(chs[i]);
                answer.add(builder.toString());
                indentLevel ++;
                builder = new StringBuilder();
            } else if (chs[i] == ',') {
                builder.append(chs[i]);
                String stringWithoutIndent = builder.toString();
                String indentSpaces = getIndentSpaces(indentLevel);
                answer.add(indentSpaces + stringWithoutIndent);
                builder = new StringBuilder();
            } else if (chs[i] == '}' || chs[i] == ']') {
                collectBuilderAndAddToAnswer(answer, indentLevel, builder);
                indentLevel --;
                builder = new StringBuilder(getIndentSpaces(indentLevel));
                builder.append(chs[i]);
                i++;
                if (i < chs.length && chs[i] == ',') {
                    builder.append(chs[i]);
                } else {
                    i--;
                }
                answer.add(builder.toString());
                builder = new StringBuilder();
            } else if (chs[i] == ' ') {
                // ignore
            } else {
                builder.append(chs[i]);
            }
        }

        return answer;
    }

    private void collectBuilderAndAddToAnswer(ArrayList<String> answer, int indentLevel, StringBuilder builder) {
        if (builder.length() > 0) {
            String stringWithoutIndent = builder.toString();
            String indentSpaces = getIndentSpaces(indentLevel);
            answer.add(indentSpaces + stringWithoutIndent);
        }
    }

    private String getIndentSpaces(int indentLevel) {
        StringBuilder builder = new StringBuilder();
        for (int j=0; j<indentLevel; j++) {
            builder.append("\t");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String input = "{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}, K:\"L\"}}";
        PrettyJson p = new PrettyJson();
        ArrayList<String> answer = p.prettyJSON(input);
        for (String str: answer) {
            System.out.println(str);
        }
    }
}
