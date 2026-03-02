package com.boleia.boleia.domain.model.User.dto;

import com.boleia.boleia.domain.model.User.UserType;

public record UpdateUserDto(
    String firstName,
    String lastName,
    String phoneNumber,
    UserType type
) {}
