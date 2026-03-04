package com.boleia.boleia.travel.application;

import java.util.UUID;

public record EvaluateUserInput(
    UUID userId,
    Integer ratingValue
) {}
