package com.sungbum.htmlanalyzer.sort;

public class NumberInputValidator implements InputValidator {

    @Override
    public boolean isValid(char c) {
        return Character.isDigit(c);
    }
}
