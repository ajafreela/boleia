package com.boleia.boleia.domain.model.Vehicle.dto;

import com.boleia.boleia.domain.model.Vehicle.VehicleStatus;

public record ChangeVehicleStatusDto(
    VehicleStatus status
) {}
