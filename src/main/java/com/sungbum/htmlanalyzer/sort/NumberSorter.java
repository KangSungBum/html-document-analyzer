package com.sungbum.htmlanalyzer.sort;

import java.util.Comparator;

public class NumberSorter extends AbstractSorter {
    private final Comparator<Character> comparator = new NumberComparator();
    private final InputValidator inputValidator = new NumberInputValidator();

    @Override
    Comparator<Character> getComparator() {
        return this.comparator;
    }


    @Override
    boolean isValid(char c) {
        return this.inputValidator.isValid(c);
    }
}
