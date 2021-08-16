package com.mood;

public class Experiment {

    /**
     * Uses repeated concatenation to compose a String with n copies of character c.
     */

    public static String repeat1(char c, int n) {
        String answer = "";
        for (int j = 0; j < n; j++)
            answer += c;
        return answer;
    }

    /**
     * Uses StringBuilder to compose a String with n copies of character c.
     */

    public static String repeat2(char c, int n) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++)
            sb.append(c);
        return sb.toString();
    }

}
