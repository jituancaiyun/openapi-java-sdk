package com.shinemo.openapi.client.dto.notice;

/**
 * 公告附件
 *
 * @author yuanjian
 * date 1/8/18
 * email liuyj@shinemo.com
 */
public class Annex {
    private String fileName;
    private long fileSize;
    private String fileType;
    private String fileKey;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileKey() {
        return fileKey;
    }

    public void setFileKey(String fileKey) {
        this.fileKey = fileKey;
    }

    @Override
    public String toString() {
        return "Annex{" +
                "fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                ", fileType='" + fileType + '\'' +
                ", fileKey='" + fileKey + '\'' +
                '}';
    }
}
