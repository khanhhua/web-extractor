package com.millennium.webextractor.controller;

import com.millennium.webextractor.model.File;
import com.millennium.webextractor.model.Link;
import com.millennium.webextractor.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URL;

@RestController
public class ExtractingController {

    @Autowired
    private StorageService storageService;

    @RequestMapping("/extract")
    public Link extract(@RequestParam(value="page") String page) throws MalformedURLException {
        URL pageUrl = new URL(page);
        File htmlFile = storageService.saveFromUrl(pageUrl);
        return new Link(htmlFile.getPath(), htmlFile.getName());
    }
}
