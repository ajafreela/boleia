package com.boleia.boleia.domain.model.travel.dto;

import java.util.UUID;

public record CreateTravelDto(
    UUID vehicleId,
    UUID driverId,
    String price,
    String destiny,
    String timeToTravel,
    String dateToTravel,
    String origin
) {}

