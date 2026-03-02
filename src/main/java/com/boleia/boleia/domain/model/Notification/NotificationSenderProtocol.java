package com.boleia.boleia.domain.model.Notification;

public interface NotificationSenderProtocol {
    void send(String to, String message);
}
