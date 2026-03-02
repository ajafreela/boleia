package com.boleia.boleia.domain.model.Vehicle.dto;

import java.util.UUID;

public record CreateVehicleDto(
    String plate,
    String brand,
    String color,
    String seats,
    UUID driverId
) {}
