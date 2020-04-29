package com.sungbum.htmlanalyzer.extract;

import com.sungbum.htmlanalyzer.sort.AlphabetInputValidator;
import com.sungbum.htmlanalyzer.sort.InputValidator;

public class AlphabetExtractor extends AbstractExtractor {

    private InputValidator inputValidator = new AlphabetInputValidator();


    @Override
    boolean isValid(char c) {
        return inputValidator.isValid(c);
    }
}
