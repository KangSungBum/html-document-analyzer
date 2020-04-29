package com.sungbum.htmlanalyzer.sort;

import org.junit.Test;

import java.util.Arrays;

public class AlphabetComparatorTest {
    private final AlphabetComparator comparator = new AlphabetComparator();

    @Test
    public void compare() {
        String str = "aaaabcdeABCDEbbdwf";
        Character[] characters = str.chars().mapToObj(value -> (char) value).toArray(Character[]::new);
        Arrays.sort(characters, comparator);

        for (char c : characters) {
            System.out.print(c);
        }
    }
}

