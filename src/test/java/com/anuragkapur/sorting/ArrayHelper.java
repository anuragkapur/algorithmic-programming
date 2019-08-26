package com.anuragkapur.sorting;

/**
 * @author anuragkapur
 */
public class ArrayHelper {

    public static String arrayAsString(int a[]) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int element : a) {
            builder.append(element);
            builder.append(",");
        }

        if(builder.length() > 1)
            builder.setLength(builder.length()-1);

        builder.append("]");
        return builder.toString();
    }
}
