package dev.etimbuk.lombok;

import lombok.Value;

@Value
public class EmailAttachment {
    byte[] data;
    String contentType;
    String filename;

    public static EmailAttachment csv(final byte[] content, final String fileName) {
        return create("text/csv", content, fileName);
    }

    private static EmailAttachment create(final String contentType, final byte[] content, final String filename) {
        return new EmailAttachment(content, contentType, filename);
    }
}
