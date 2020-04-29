package com.sungbum.htmlanalyzer.extract;

import java.util.List;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberExtractorTest {
    private final Extractor extractor = new NumberExtractor();

    @Test
    public void test_extract() {
        String source = "1234)($*@)#(*@)(#*abcd";

        String extracted = extractor.extract(source);

        assertEquals(extracted, "1234");
    }

    @Test
    public void test_extract_many() {
        String source1 = "1234)($*@)#(*@)(#*abcd";
        String source2 = "5555)($*@)#(*@)(#*efgh";
        String source3 = ")($*@)#(*@)(#*";

        String extracted = extractor.extract(List.of(source1, source2, source3));

        assertEquals(extracted, "12345555");
    }
}
