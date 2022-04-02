package dev.etimbuk.record;

import java.util.Objects;
import java.util.Set;

public record EmailData(
        String recipient,
        String subject,
        String message,
        Set<EmailAttachment> emailAttachments) {
    public EmailData {
        Objects.requireNonNull(recipient);
        subject = Objects.requireNonNullElse(subject, "");
        message = Objects.requireNonNullElse(message, "");
    }
}
