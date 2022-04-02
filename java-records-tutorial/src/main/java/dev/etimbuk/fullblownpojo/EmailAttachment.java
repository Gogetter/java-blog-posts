package dev.etimbuk.fullblownpojo;

import java.util.Arrays;
import java.util.Objects;

public class EmailAttachment {
    private byte[] data;
    private String contentType;
    private String filename;

    public EmailAttachment() {
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getContentTy() {
        return contentType;
    }

    public void setContentTy(String contentTy) {
        this.contentType = contentTy;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailAttachment that = (EmailAttachment) o;
        return Arrays.equals(data, that.data) && Objects.equals(contentType, that.contentType) && Objects.equals(filename, that.filename);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(contentType, filename);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    @Override
    public String toString() {
        return "EmailAttachment{" +
                "data=" + Arrays.toString(data) +
                ", contentType='" + contentType + '\'' +
                ", filename='" + filename + '\'' +
                '}';
    }
}
