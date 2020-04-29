package com.sungbum.htmlanalyzer;

import java.util.ArrayList;
import java.util.List;
import lombok.ToString;

@ToString
public class Document {

    private List<String> tags = new ArrayList<>();
    private List<String> elements = new ArrayList<>();
    private String rawHtml;


    public void setRawHtml(String rawHtml) {
        this.rawHtml = rawHtml;
    }


    public void addTag(String tag) {
        if(tag != null && tag.trim().length() > 0) {
            tags.add(tag);
        }
    }


    public void addElement(String element) {
        if(element != null && element.trim().length() > 0) {
            elements.add(element);
        }
    }


    public List<String> getTags() {
        return this.tags;
    }


    public List<String> getElements() {
        return this.elements;
    }

    public String getRawHtml() {
        return this.rawHtml;
    }
}
