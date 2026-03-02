package com.boleia.boleia.infra.repository.Vehicle.schema;

import java.time.LocalDateTime;
import java.util.UUID;

import com.boleia.boleia.domain.model.Vehicle.VehicleStatus;

public record VehicleResponse(
    UUID id,
    String plate,
    String brand,
    String color,
    String seats,
    VehicleStatus status,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}
