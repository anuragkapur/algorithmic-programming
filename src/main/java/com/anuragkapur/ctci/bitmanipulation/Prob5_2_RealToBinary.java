package com.anuragkapur.ctci.bitmanipulation;

/**
 * @author anuragkapur
 */
public class Prob5_2_RealToBinary {

    public static String convert(double num) {

        StringBuilder binary = new StringBuilder();
        binary.append("0.");
        while(num > 0) {
            if (binary.length() == 32) {
                return "ERROR";
            }

            num = num * 2;
            if (num >= 1) {
                binary.append("1");
                num = num - 1;
            } else {
                binary.append("0");
            }
        }

        return binary.toString();
    }
}
