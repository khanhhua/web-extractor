package com.millennium.webextractor.model;

public class File {
    private String path;
    private FileType type;
    private String name;

    public File(String path, FileType type, String name) {
        this.path = path;
        this.type = type;
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
