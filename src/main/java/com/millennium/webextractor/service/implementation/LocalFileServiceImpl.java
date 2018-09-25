package com.millennium.webextractor.service.implementation;

import com.millennium.webextractor.model.File;
import com.millennium.webextractor.service.StorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

@Service("fileSystem")
public class LocalFileServiceImpl implements StorageService {
    //@Value( value = "${storage.path}" )
    private String storagePath = "/tmp/";

    @Override
    public File saveFromUrl(URL url) {
        try {
            ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
            String path = url.getPath();
            String fileName = path.substring(path.lastIndexOf('/')+1, path.length());
            return new File(storagePath + fileName, null, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
