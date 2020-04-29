package com.sungbum.htmlanalyzer.controller;

import com.sungbum.htmlanalyzer.Document;
import com.sungbum.htmlanalyzer.DocumentFactory;
import com.sungbum.htmlanalyzer.crawl.HttpCrawler;
import com.sungbum.htmlanalyzer.extract.AlphabetExtractor;
import com.sungbum.htmlanalyzer.extract.Extractor;
import com.sungbum.htmlanalyzer.extract.NumberExtractor;
import com.sungbum.htmlanalyzer.sort.AlphabetSorter;
import com.sungbum.htmlanalyzer.sort.NumberSorter;
import com.sungbum.htmlanalyzer.sort.Sorter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DocumentController {

    private final Extractor numberExtractor = new NumberExtractor();
    private final Extractor alphabetExtractor = new AlphabetExtractor();
    private final Sorter numberSorter = new NumberSorter();
    private final Sorter alphabetSorter = new AlphabetSorter();


    @GetMapping("/document")
    public String show(Model model) {
        return "form";
    }


    @PostMapping("/document")
    public String submit(Model model, String url, String type, Integer divider) {
        Document document;

        try {
            DocumentFactory documentFactory = new DocumentFactory(url, new HttpCrawler());
            document = documentFactory.process();

            String numbers, alphabets;
            if(type.equals("removeTags")) {
                numbers = numberExtractor.extract(document.getElements());
                alphabets = alphabetExtractor.extract(document.getElements());
            } else {
                numbers = numberExtractor.extract(document.getRawHtml());
                alphabets = alphabetExtractor.extract(document.getRawHtml());
            }

            numbers = numberSorter.sort(numbers);
            alphabets = alphabetSorter.sort(alphabets);

            String merged = documentFactory.mergeTwoStringAlternately(alphabets, numbers);
            int quotient = (merged.length() / divider);
            int splitPoint = divider * quotient;

            model.addAttribute("quotient", merged.substring(0, splitPoint));
            model.addAttribute("remainder", merged.substring(splitPoint));
            model.addAttribute("url", url);
            model.addAttribute("type", type);
            model.addAttribute("divider", divider);

        } catch(Exception e) {
            model.addAttribute("exceptionMessage", e.getMessage());
            e.printStackTrace();
        }

        return "form";
    }


    @GetMapping("/sample")
    public String sample(Model model) {
        return "sample";
    }
}
