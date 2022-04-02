package dev.etimbuk.fullblownpojo;

import java.util.Objects;
import java.util.Set;

public class EmailData {
    private String recipient;
    private String subject;
    private String message;
    private Set<EmailAttachment> emailAttachments;

    public EmailData() {
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailData emailData = (EmailData) o;
        return Objects.equals(recipient, emailData.recipient) && Objects.equals(subject, emailData.subject) && Objects.equals(message, emailData.message) && Objects.equals(emailAttachments, emailData.emailAttachments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipient, subject, message, emailAttachments);
    }

    @Override
    public String toString() {
        return "EmailData{" +
                "recipient='" + recipient + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

