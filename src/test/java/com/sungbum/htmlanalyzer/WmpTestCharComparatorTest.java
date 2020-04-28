package com.sungbum.htmlanalyzer;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class WmpTestCharComparatorTest {
    private final WmpTestCharComparator comparator = new WmpTestCharComparator();

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

