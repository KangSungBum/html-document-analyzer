package com.sungbum.htmlanalyzer.sort;

import com.sungbum.htmlanalyzer.exception.UnsupportedFormatException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NumberSorterTest {
    private final Sorter numberSorter = new NumberSorter();

    @Test
    public void test_sort() {
        String input = "531422";

        assertEquals(numberSorter.sort(input), "122345");
    }

    @Test(expected = UnsupportedFormatException.class)
    public void test_sort_throws_exception(){
        String input = "abcde";
        numberSorter.sort(input);
    }
}
