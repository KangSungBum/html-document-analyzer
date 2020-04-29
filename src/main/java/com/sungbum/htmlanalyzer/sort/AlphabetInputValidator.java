package com.sungbum.htmlanalyzer.sort;

public class AlphabetInputValidator implements InputValidator {

    @Override
    public boolean isValid(char c) {
        return Character.isLowerCase(c) || Character.isUpperCase(c);
    }
}
