package com.sungbum.htmlanalyzer;

public class IsUtil {
    public static boolean isAlphabet(char c) {
        return isLowerCase(c) || isUpperCase(c);
    }

    public static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static boolean isNumeric(char c) {
        return c >= '0' && c <= '9';
    }
}
