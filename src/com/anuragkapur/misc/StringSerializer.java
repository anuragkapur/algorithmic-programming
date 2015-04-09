package com.anuragkapur.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anuragkapur
 */
public class StringSerializer {

    private final char DEMARKER = '.';

    public String serialize(List<String> strings) {

        StringBuilder builder = new StringBuilder();
        for (String str : strings) {
            builder.append(str);
            builder.append(DEMARKER);
            builder.append(str.length());
        }

        return builder.toString();
    }

    public List<String> deserialize(String serializedString, List<String> strings) {

        char serializedChars[] = serializedString.toCharArray();
        int lengthOfLastStringInList = 0;
        int posOfLastDemarker = 0;
        for (int i=serializedChars.length-1; i>=0; i--) {
            if (serializedChars[i] == '.') {
                posOfLastDemarker = i;
                lengthOfLastStringInList = Integer.parseInt(serializedString.substring(i+1, serializedChars.length));
                break;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i=posOfLastDemarker-lengthOfLastStringInList; i<posOfLastDemarker; i++) {
            builder.append(serializedChars[i]);
        }

        if (strings == null) {
            strings = new ArrayList<>();
        }

        strings.add(builder.toString());

        if (posOfLastDemarker-lengthOfLastStringInList > 0) {
            String leftoverString = serializedString.substring(0, posOfLastDemarker-lengthOfLastStringInList);
            return deserialize(leftoverString, strings);
        } else {
            return strings;
        }
    }
}

