package com.boleia.boleia.domain.model.User.dto;


public record ChangePasswordDto(
    String oldPassword,
    String confirmPassword,
    String newPassword
) {}
