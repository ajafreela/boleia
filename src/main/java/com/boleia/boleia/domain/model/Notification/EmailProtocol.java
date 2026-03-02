package com.boleia.boleia.domain.model.Notification;

public interface EmailProtocol extends NotificationSenderProtocol {
    void sendEmail(String to, String subject, String message);
}
