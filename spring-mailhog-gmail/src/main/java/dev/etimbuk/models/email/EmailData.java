package dev.etimbuk.models.email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.etimbuk.models.payload.request.EmailSendRequest;
import lombok.Builder;
import lombok.Value;

import java.util.Set;

import static dev.etimbuk.models.email.EmailAttachment.csv;
import static java.util.Set.of;
import static org.springframework.util.CollectionUtils.isEmpty;

@Value
@Builder(toBuilder = true)
public class EmailData {
    private final String recipient;
    private final String subject;
    private final String message;
    private final Set<EmailAttachment> attachments;

    @JsonIgnore
    public boolean hasAttachments() {
        return (!isEmpty(attachments));
    }

    public static EmailData from(final EmailSendRequest request) {
        return EmailData.builder()
                .message("")
                .subject(request.getSubject())
                .recipient(request.getRecipient())
                .attachments(of(csv(request.getFileContent().getBytes(), "EmailTest")))
                .build();
    }
}
