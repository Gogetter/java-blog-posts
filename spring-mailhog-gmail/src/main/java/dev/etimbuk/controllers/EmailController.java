package dev.etimbuk.controllers;

import dev.etimbuk.models.email.EmailData;
import dev.etimbuk.models.payload.request.EmailSendRequest;
import dev.etimbuk.models.payload.response.EmailSendResponse;
import dev.etimbuk.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(value = "email")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmailController {

    private final EmailService emailService;

    @PostMapping("send")
    public ResponseEntity<EmailSendResponse> sendEmail(@RequestBody @Valid EmailSendRequest emailSendRequest) {

        try {
            emailService.sendEmail(emailSendRequest.getSender(), EmailData.from(emailSendRequest));

            return ResponseEntity.status(OK).body(EmailSendResponse.builder()
                    .success(true)
                    .message("Email sent successfully.")
                    .build());

        } catch (Exception exc) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(EmailSendResponse.builder()
                    .success(false)
                    .message(String.format("Failed to send email due to %s", exc.getMessage()))
                    .build());
        }
    }
}
