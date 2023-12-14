package com.api.msemail.controller;

import com.api.msemail.request.EmailRequest;
import com.api.msemail.response.EmailResponse;
import com.api.msemail.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send-email")
    public ResponseEntity<EmailResponse> sendEmail(@RequestBody EmailRequest emailRequest) {
        return ResponseEntity.ok().body(this.emailService.sendEmail(emailRequest));
    }
}
