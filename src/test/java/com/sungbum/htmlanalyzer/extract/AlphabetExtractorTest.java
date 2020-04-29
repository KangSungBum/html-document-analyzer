package com.sungbum.htmlanalyzer.extract;

import java.util.List;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlphabetExtractorTest {
    private final Extractor extractor = new AlphabetExtractor();

    @Test
    public void test_extract() {
        String source = "1234)($*@)#(*@)(#*abcd";

        String extracted = extractor.extract(source);

        assertEquals(extracted, "abcd");
    }

    @Test
    public void test_extract_many() {
        String source1 = "1234)($*@)#(*@)(#*abcd";
        String source2 = "1234)($*@)#(*@)(#*efgh";
        String source3 = "1234)($*@)#(*@)(#*";

        String extracted = extractor.extract(List.of(source1, source2, source3));

        assertEquals(extracted, "abcdefgh");
    }
}
