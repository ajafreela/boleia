package com.boleia.boleia.domain.model.Notification.dto;

public record ValidationOtpDto(
    String phoneNumber,
    String otp
) {}
