package dev.etimbuk.models.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EmailSendRequest {
    @NotBlank (message = "subject cannot be blank or null")
    private String subject;

    @NotBlank (message = "recipient cannot be blank or null")
    private String recipient;

    @NotBlank (message = "sender cannot be blank or null")
    private String sender;

    private String fileContent;
}
