package com.sungbum.htmlanalyzer.extract;

import java.util.List;

public abstract class AbstractExtractor implements Extractor {

    abstract boolean isValid(char c);


    @Override
    public String extract(String source) {
        if(source == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        for(char c : source.toCharArray()) {
            if(this.isValid(c)) {
                builder.append(c);
            }
        }

        return builder.toString();
    }

    @Override
    public String extract(List<String> sources) {
        if(sources == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder();

        for (String source : sources) {
            builder.append(this.extract(source));
        }

        return builder.toString();
    }

}
