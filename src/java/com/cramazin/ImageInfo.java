
package com.cramazin;

public class ImageInfo {
    private final int id;
    private final String fileName;
    private final String contentType;

    
    private String imageType;
   
    
    public ImageInfo(int id, String fileName, String contentType) {
        this.id = id;
        this.fileName = fileName;
        this.contentType = contentType;
    }

    public ImageInfo(int id, String fileName, String contentType, String imageType) {
        this.id = id;
        this.fileName = fileName;
        this.contentType = contentType;
        this.imageType = imageType;
    }
    
    
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

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }
}
