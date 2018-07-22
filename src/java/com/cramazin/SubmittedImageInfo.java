
package com.cramazin;


public class SubmittedImageInfo {
    private final int id;
    private final String fileName;
    private final String contentType;
    private final String imageType;

    public int getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public String getImageType() {
        return imageType;
    }

    public SubmittedImageInfo(int id, String fileName, String contentType, String imageType) {
        this.id = id;
        this.fileName = fileName;
        this.contentType = contentType;
        this.imageType = imageType;
    }
    

    
}
