package com.sungbum.htmlanalyzer.crawl;

import java.io.IOException;
import java.net.URI;

public interface Crawler {
    String crawl(URI uri) throws IOException, InterruptedException;
}
