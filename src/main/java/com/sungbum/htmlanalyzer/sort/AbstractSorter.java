package com.sungbum.htmlanalyzer.sort;

import java.util.Arrays;
import java.util.Comparator;
import com.sungbum.htmlanalyzer.exception.UnsupportedFormatException;

public abstract class AbstractSorter implements Sorter {

    abstract Comparator<Character> getComparator();

    abstract boolean isValid(char c);


    @Override
    public final String sort(String input) {
        for(char c : input.toCharArray()) {
            if(!this.isValid(c)) {
                throw new UnsupportedFormatException(Character.toString(c));
            }
        }

        Character[] characters =
                input.chars().mapToObj(value -> (char) value).toArray(Character[]::new);
        Arrays.sort(characters, getComparator());

        StringBuilder builder = new StringBuilder();
        for(char c : characters) {
            builder.append(c);
        }

        return builder.toString();
    }
}
