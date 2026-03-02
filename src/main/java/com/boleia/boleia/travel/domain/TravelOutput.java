package com.boleia.boleia.travel.domain;

import java.math.BigDecimal;
import java.util.UUID;

public record TravelOutput(
    String id,
    UUID vehicleId,
    UUID driverId,
    String dateToTravel,
    TravelStatus status,
    BigDecimal price,
    String origin,
    String destiny,
    Integer seats,
    String createdAt,
    String updatedAt
) {}
