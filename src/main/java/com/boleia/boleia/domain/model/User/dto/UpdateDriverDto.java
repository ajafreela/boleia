package com.boleia.boleia.domain.model.User.dto;


public record UpdateDriverDto (
    String firstName,
    String lastName,
    String phoneNumber,
    String identificationNumber,
    String licenseNumber
) {}
