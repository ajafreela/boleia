package com.boleia.boleia.domain.model.User.dto;


public record CreateDriverDto (
    String firstName,
    String lastName,
    String phoneNumber,
    String identificationNumber,
    String password,
    String licenseNumber,
    Boolean isDriver
) {}
