package com.sungbum.htmlanalyzer;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContentExtractorTest {
    private final ContentExtractor contentExtractor = new ContentExtractor();

    @Test
    public void test_extractContent() {

        String html = "<html>aaaaa</aaaaa>";
        assertEquals(contentExtractor.extractContent(html), "aaaaa");

        html = "<<<<<<<html>aaaaa</aaaaa>";
        assertEquals(contentExtractor.extractContent(html), "aaaaa");

        html = "<<<<<<<html>>>>aaaaa</aaaaa>";
        assertEquals(contentExtractor.extractContent(html), ">>>aaaaa");

        html = "<<<<<<<html>>>>aaaaa</aaaaa>>>>>>>";
        assertEquals(contentExtractor.extractContent(html), ">>>aaaaa>>>>>>");

        assertNull(contentExtractor.extractContent(null));
    }
}