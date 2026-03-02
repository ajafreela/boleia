package com.boleia.boleia.infra.repository.User.schema;

import java.time.LocalDateTime;
import java.util.UUID;

import com.boleia.boleia.domain.model.User.EntityStatus;
import com.boleia.boleia.domain.model.User.UserType;
import com.boleia.boleia.infra.entity.User.DriverEntity;

public record UserResponse(
    UUID id,
    String firstName,
    String lastName,
    String phoneNumber,
    UserType type,
    EntityStatus status,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    DriverEntity driver
) {}