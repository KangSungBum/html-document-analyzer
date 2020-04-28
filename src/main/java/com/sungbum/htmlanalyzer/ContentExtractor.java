package com.sungbum.htmlanalyzer;

public class ContentExtractor {
    private static final char OPEN_TAG = '<';
    private static final char CLOSE_TAG = '>';

    public String extractContent(String html) {
        if (html == null) {
            return null;
        }

        boolean isTagOpened = false;
        StringBuilder stringBuilder = new StringBuilder();

        for (char c : html.toCharArray()) {
            switch (c) {
                case OPEN_TAG:
                    isTagOpened = true;
                    break;

                case CLOSE_TAG:
                    if (isTagOpened) {
                        isTagOpened = false;
                    } else {
                        stringBuilder.append(c);
                    }
                    break;

                default:
                    if (!isTagOpened) {
                        stringBuilder.append(c);
                    }
                    break;
            }
        }

        return stringBuilder.toString();
    }
}
