package com.boleia.boleia.infra.controller.travel.input;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record RequestTripInput(
    @NotNull(message = "Travel id can not be not null")
    UUID travelId,
    @NotNull(message = "Travel id can not be not null")
    UUID passangerId
) {}
