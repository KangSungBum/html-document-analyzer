package com.sungbum.htmlanalyzer;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsUtilTest {
   private final String upperCases = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String lowerCases = "abcdefghijklmnopqrstuvwxyz";
    private final String numbers = "0123456789";
    private final String specialChars = "!@#$%^&*())_+=";

    @Test
    public void test_isAlphabet() {
        for (char c : upperCases.toCharArray()) {
            assertTrue(IsUtil.isAlphabet(c));
        }

        for (char c : lowerCases.toCharArray()) {
            assertTrue(IsUtil.isAlphabet(c));
        }

        for (char c : numbers.toCharArray()) {
            assertFalse(IsUtil.isAlphabet(c));
        }

        for (char c : specialChars.toCharArray()) {
            assertFalse(IsUtil.isAlphabet(c));
        }

    }

    @Test
    public void test_isNumeric() {
        for (char c : upperCases.toCharArray()) {
            assertFalse(IsUtil.isNumeric(c));
        }

        for (char c : lowerCases.toCharArray()) {
            assertFalse(IsUtil.isNumeric(c));
        }

        for (char c : numbers.toCharArray()) {
            assertTrue(IsUtil.isNumeric(c));
        }

        for (char c : specialChars.toCharArray()) {
            assertFalse(IsUtil.isNumeric(c));
        }
    }
}