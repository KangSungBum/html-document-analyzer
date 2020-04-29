package com.sungbum.htmlanalyzer.extract;

import com.sungbum.htmlanalyzer.sort.InputValidator;
import com.sungbum.htmlanalyzer.sort.NumberInputValidator;

public class NumberExtractor extends AbstractExtractor {

    private InputValidator inputValidator = new NumberInputValidator();


    @Override
    boolean isValid(char c) {
        return inputValidator.isValid(c);
    }
}
