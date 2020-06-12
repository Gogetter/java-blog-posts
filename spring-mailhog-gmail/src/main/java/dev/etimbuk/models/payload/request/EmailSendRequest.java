package dev.etimbuk.models.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder(toBuilder = true)
public class EmailSendRequest {
    @NotBlank (message = "subject cannot be blank or null")
    private String subject;

    @NotBlank (message = "recipient cannot be blank or null")
    private String recipient;

    @NotBlank (message = "sender cannot be blank or null")
    private String sender;

    private String fileContent;
}
