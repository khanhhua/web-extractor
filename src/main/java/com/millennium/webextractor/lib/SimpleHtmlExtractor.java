package com.millennium.webextractor.lib;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SimpleHtmlExtractor{

    private static final String RESOURCE_PATTERN =
            "([^\\s]+(\\.(?i)(jpg|png|gif|bmp|js|css))$)";

    private static Pattern pattern = Pattern.compile(RESOURCE_PATTERN);;

    private Document document;

    SimpleHtmlExtractor(Document document){
        this.document = document;
    }

    SimpleHtmlExtractor(String htmlString){
        this.document = Jsoup.parse(htmlString);
    }

    public static SimpleHtmlExtractor loadFromString(String htmlString){
        Document document = Jsoup.parse(htmlString);
        return new SimpleHtmlExtractor(document);
    }

    public static SimpleHtmlExtractor loadFromUrl(String htmlUrl) throws IOException {
        Document document = Jsoup.connect(htmlUrl).get();
        return new SimpleHtmlExtractor(document);
    }


    public Set<String> extractStaticResources() {
        Set<String> resources = new HashSet<>();

        Elements cssFiles = document.select("link");
        resources.addAll(cssFiles.eachAttr("href"));

        Elements jsFiles = document.select("script");
        resources.addAll(jsFiles.eachAttr("src"));

        Elements images = document.select("img");
        resources.addAll(images.eachAttr("src"));

        return resources.parallelStream()
                .filter( r -> StringUtils.isNotEmpty(r))
                .filter( r -> pattern.matcher(r).matches())
                .collect(Collectors.toSet());
    }

    public void replaceResources(Map<String, String> resources) {
    }

    public void replaceResource(String originalResource, String replaceResource) {
    }
}
