package dev.etimbuk.models.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class EmailSendResponse {
    private boolean success;
    private String message;
}
