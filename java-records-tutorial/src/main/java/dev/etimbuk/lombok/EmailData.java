package dev.etimbuk.lombok;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Value;

import java.util.Set;

@Value
public class EmailData {
    String recipient;
    String subject;
    String message;
    Set<EmailAttachment> attachments;

    @JsonIgnore
    public boolean hasAttachments() {
        return (attachments != null && !attachments.isEmpty());
    }
}
