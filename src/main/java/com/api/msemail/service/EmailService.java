package com.api.msemail.service;

import com.api.msemail.enumeration.StatusEmail;
import com.api.msemail.request.EmailRequest;
import com.api.msemail.response.EmailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {
    private final JavaMailSender emailSender;
    @Autowired
    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }
    public EmailResponse sendEmail(EmailRequest emailRequest) {
        EmailResponse response = new EmailResponse();
        response.setSendTo(emailRequest.to());
        response.setSendDateEmail(LocalDateTime.now());

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailRequest.to());
            message.setSubject(emailRequest.subject());
            message.setText(emailRequest.text());
            emailSender.send(message);

            response.setStatusEmail("Sent Email");
        } catch (MailAuthenticationException | MailSendException e) {
            response.setStatusEmail("Failed: Authentication or sending error - " + e.getMessage());
        } catch (MailException e) {
            response.setStatusEmail("Failed: General mail error - " + e.getMessage());
        }
        return response;
    }
}
