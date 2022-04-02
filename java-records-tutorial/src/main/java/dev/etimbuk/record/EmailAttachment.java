package dev.etimbuk.record;

public record EmailAttachment(
        byte[] data,
        String contentType,
        String filename) {
}
