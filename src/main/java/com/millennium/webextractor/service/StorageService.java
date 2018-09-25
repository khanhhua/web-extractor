package com.millennium.webextractor.service;

import com.millennium.webextractor.model.File;

import java.net.URL;

public interface StorageService {
    File saveFromUrl(URL url);
}
