package com.boleia.boleia.domain.model.Notification;

public interface OtpProtocol extends NotificationSenderProtocol{ 
    void sendOtp(String to, String otp);   
}
