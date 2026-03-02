package com.boleia.boleia.infra.repository.User.schema;

import java.time.LocalDateTime;
import java.util.UUID;

// import com.boleia.boleia.infra.entity.User.UserEntity;

public record DriverResponse(
    UUID id,
    String identificationNumber,
    String licenseNumber,
    // UserEntity user,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}
