package com.sungbum.htmlanalyzer.sort;

import com.sungbum.htmlanalyzer.exception.UnsupportedFormatException;
import org.junit.Test;
import static org.junit.Assert.*;

public class AlphabetSorterTest {
    private final Sorter alphabetSorter = new AlphabetSorter();

    @Test
    public void test_sort() {
        String input = "aACcBb";

        assertEquals(alphabetSorter.sort(input), "AaBbCc");
    }

    @Test(expected = UnsupportedFormatException.class)
    public void test_sort_throws_exception(){
        String input = "12345";
        alphabetSorter.sort(input);
    }
}
