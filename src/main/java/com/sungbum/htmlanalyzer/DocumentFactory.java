package com.sungbum.htmlanalyzer;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.stream.IntStream;
import com.sungbum.htmlanalyzer.crawl.Crawler;

public class DocumentFactory {

    private URI uri;
    private Crawler crawler;

    private static final char OPEN_TAG = '<';
    private static final char CLOSE_TAG = '>';


    public DocumentFactory(URI uri, Crawler crawler) {
        this.uri = uri;
        this.crawler = crawler;
    }


    public DocumentFactory(String uri, Crawler crawler) throws URISyntaxException {
        this.uri = new URI(uri);
        this.crawler = crawler;
    }


    public Document process() throws IOException, InterruptedException {
        Document document = new Document();

        String html = crawler.crawl(this.uri);

        if(html == null) {
            return document;
        }

        document.setRawHtml(html);

        boolean isTagOpened = false;

        StringBuilder stringBuilder = null;

        for(char c : html.toCharArray()) {
            switch(c) {
                case OPEN_TAG:
                    if(!isTagOpened) {
                        isTagOpened = true;
                        if(stringBuilder != null) {
                            document.addElement(stringBuilder.toString());
                        }
                        stringBuilder = new StringBuilder();
                    }
                    stringBuilder.append(OPEN_TAG);
                    break;

                case CLOSE_TAG:
                    if(isTagOpened) {
                        isTagOpened = false;
                        stringBuilder.append(CLOSE_TAG);
                        document.addTag(stringBuilder.toString());
                        stringBuilder = new StringBuilder();
                    } else {
                        stringBuilder.append(c);
                    }
                    break;

                default:
                    if(stringBuilder == null) {
                        stringBuilder = new StringBuilder();
                    }
                    stringBuilder.append(c);
                    break;
            }
        }

        if(stringBuilder != null && stringBuilder.capacity() > 0
                && document.getElements().size() > 0) {
            String lastElement = document.getElements().get(document.getElements().size() - 1);
            document.getElements()
                    .set(document.getElements().size() - 1, lastElement + stringBuilder.toString());
        } else if(stringBuilder != null && stringBuilder.capacity() > 0) {
            document.addElement(stringBuilder.toString());
        }

        return document;
    }


    public String mergeTwoStringAlternately(String alphabets, String numbers) {
        int min = Math.min(alphabets.length(), numbers.length());

        int alphabetsLength = alphabets.length();
        int numbersLength = numbers.length();

        String remainder = "";
        if(alphabetsLength > numbersLength) {
            remainder = alphabets.substring(numbersLength);
        } else if(alphabetsLength < numbersLength) {
            remainder = numbers.substring(alphabetsLength);
        }

        IntStream commonRange = IntStream.range(0, min);
        StringBuilder builder = new StringBuilder();
        commonRange.forEach(
                value -> builder.append(alphabets.charAt(value)).append(numbers.charAt(value)));

        builder.append(remainder);

        return builder.toString();
    }

}
