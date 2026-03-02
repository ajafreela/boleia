package com.boleia.boleia.application.travel.input;

import java.util.UUID;

public record RequestTripInput(
    UUID travelId,
    UUID passangerId
) {}
