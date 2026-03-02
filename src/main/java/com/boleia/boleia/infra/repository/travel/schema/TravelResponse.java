package com.boleia.boleia.infra.repository.travel.schema;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.boleia.boleia.domain.model.User.User;
import com.boleia.boleia.domain.model.Vehicle.Vehicle;
import com.boleia.boleia.domain.model.travel.TravelStatus;

public record TravelResponse(
    UUID id,
    Vehicle vehicle,
    LocalDateTime startTime,
    TravelStatus status,
    List<User> passenger,
    String price,
    String destiny,
    List<String> stops
) {}
