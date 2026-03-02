package com.boleia.boleia.infra.entity.travel;

import java.time.LocalDateTime;
import java.util.UUID;

import com.boleia.boleia.infra.repository.User.schema.UserResponse;
import com.boleia.boleia.infra.repository.travel.schema.TravelResponse;

public record TravelPassangerResponse(
    UUID id,
    String status,
    UserResponse passanger,
    TravelResponse travel,
    LocalDateTime updatedAt,
    LocalDateTime createdAt
) {}
