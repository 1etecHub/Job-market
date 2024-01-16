package com.jobmarket.jobmarketapp.services;

import com.jobmarket.jobmarketapp.event.events.ForgotPasswordEvent;
import com.jobmarket.jobmarketapp.payload.request.MailRequest;

public interface EmailSenderService {
    void sendEmailAlert(MailRequest mailDTO);
    void sendNotificationEmail(String url, String email, String firstName, String subject, String description);

    void sendRegistrationEmailVerification(String url, String email, String firstName);
    void sendForgotPasswordEmailVerification(String url, ForgotPasswordEvent event);
}
