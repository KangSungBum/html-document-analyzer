package com.sungbum.htmlanalyzer.extract;

import java.util.List;

public interface Extractor {
    String extract(String source);
    String extract(List<String> sources);
}
