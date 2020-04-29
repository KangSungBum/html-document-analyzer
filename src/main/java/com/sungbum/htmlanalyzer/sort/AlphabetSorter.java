package com.sungbum.htmlanalyzer.sort;

import java.util.Comparator;

public class AlphabetSorter extends AbstractSorter {
    private final Comparator<Character> comparator = new AlphabetComparator();
    private final InputValidator inputValidator = new AlphabetInputValidator();

    @Override
    Comparator<Character> getComparator() {
        return this.comparator;
    }


    @Override
    boolean isValid(char c) {
        return this.inputValidator.isValid(c);
    }
}
