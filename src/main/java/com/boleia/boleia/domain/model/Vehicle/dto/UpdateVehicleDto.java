package com.boleia.boleia.domain.model.Vehicle.dto;

public record UpdateVehicleDto(
    String plate,
    String brand,
    String color,
    String seats
) {}
