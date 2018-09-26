package com.millennium.webextractor.lib;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Set;

public class SimpleHtmlExtractorTest {

    private String htmlString;

    private SimpleHtmlExtractor extractor;

    @Before
    public void setUp() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("lib/simpleHtml.html").getFile());
        htmlString = FileUtils.readFileToString(file, "UTF-8");
    }

    @Test
    public void test_extractStaticResources(){
        extractor = SimpleHtmlExtractor.loadFromString(htmlString);
        Set<String> resources = extractor.extractStaticResources();
//        for(String item : resources){
//            System.out.println(item);
//        }
        Assert.assertNotNull(resources);
        Assert.assertTrue(resources.size() > 0);
    }

}
