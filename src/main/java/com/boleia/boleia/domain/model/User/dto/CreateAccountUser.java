package com.boleia.boleia.domain.model.User.dto;


public record CreateAccountUser(
    String firstName,
    String lastName,
    String phoneNumber,
    Boolean isDriver
) {}
