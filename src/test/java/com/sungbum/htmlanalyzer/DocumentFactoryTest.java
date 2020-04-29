package com.sungbum.htmlanalyzer;

import java.io.IOException;
import java.net.URISyntaxException;
import com.sungbum.htmlanalyzer.crawl.Crawler;
import com.sungbum.htmlanalyzer.crawl.HttpCrawler;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DocumentFactoryTest {
    @Mock
    private Crawler mockCrawler;

    @Test
    public void test_process_formed() throws URISyntaxException, IOException,
            InterruptedException {
        DocumentFactory documentFactory = new DocumentFactory("https://www.daum.net", mockCrawler);
        String html = "<html>aaaaa</aaaaa>";

        when(mockCrawler.crawl(any())).thenReturn(html);
        Document document = documentFactory.process();

        System.out.println(html);
        System.out.println(document);

        assertEquals(document.getElements().get(0), "aaaaa");
        assertEquals(document.getTags().get(0), "<html>");
    }


    @Test
    public void test_process_missing_close()
            throws IOException, InterruptedException, URISyntaxException {
        String html = "<html>aaaaa</aaaaa";

        DocumentFactory documentFactory = new DocumentFactory("https://www.daum.net", mockCrawler);
        when(mockCrawler.crawl(any())).thenReturn(html);
        Document document = documentFactory.process();

        System.out.println(html);
        System.out.println(document);

        assertEquals(document.getElements().get(0), "aaaaa</aaaaa");
        assertEquals(document.getTags().get(0), "<html>");

        System.out.println(document);

    }

    @Test
    public void test_process_duplicated_open_tag()
            throws URISyntaxException, IOException, InterruptedException {

        String html = "<<<<<<<html>aaaaa</aaaaa>";
        DocumentFactory documentFactory = new DocumentFactory("https://www.daum.net", mockCrawler);
        when(mockCrawler.crawl(any())).thenReturn(html);
        Document document = documentFactory.process();


        System.out.println(html);
        System.out.println(document);

        assertEquals(document.getElements().get(0), "aaaaa");
        assertEquals(document.getTags().get(0), "<<<<<<<html>");

        System.out.println(document);
    }

    @Test
    public void test_process_no_tags()
            throws URISyntaxException, IOException, InterruptedException {

        String html = "aaaaabbbbbccccaaaaa";
        DocumentFactory documentFactory = new DocumentFactory("https://www.daum.net", mockCrawler);
        when(mockCrawler.crawl(any())).thenReturn(html);
        Document document = documentFactory.process();

        System.out.println(html);
        System.out.println(document);

        assertEquals(document.getElements().get(0), "aaaaabbbbbccccaaaaa");
        assertEquals(document.getTags().size(), 0);
    }

    @Test
    public void test_getHtml_process()
            throws IOException, InterruptedException, URISyntaxException {
        DocumentFactory documentFactory = new DocumentFactory("https://www.daum.net", new HttpCrawler());

        Document document = documentFactory.process();

        assertEquals(document.getElements().get(0), "Daum");
        assertEquals(document.getTags().get(0), "<!DOCTYPE html>");
    }

    @Test
    public void test_mergeAlternately_same_length() throws URISyntaxException {
        String alphabets = "abcde";
        String numbers = "12345";
        DocumentFactory documentFactory = new DocumentFactory("https://www.daum.net", new HttpCrawler());
        assertEquals(documentFactory.mergeTwoStringAlternately(alphabets, numbers), "a1b2c3d4e5");
    }

    @Test
    public void test_mergeAlternately_alphabets_is_long() throws URISyntaxException {
        String alphabets = "abcdefg";
        String numbers = "12345";
        DocumentFactory documentFactory = new DocumentFactory("https://www.daum.net", new HttpCrawler());
        assertEquals(documentFactory.mergeTwoStringAlternately(alphabets, numbers), "a1b2c3d4e5fg");
    }

    @Test
    public void test_mergeAlternately_numbers_is_long() throws URISyntaxException {
        String alphabets = "abcde";
        String numbers = "1234567";
        DocumentFactory documentFactory = new DocumentFactory("https://www.daum.net", new HttpCrawler());
        assertEquals(documentFactory.mergeTwoStringAlternately(alphabets, numbers), "a1b2c3d4e567");
    }
}
