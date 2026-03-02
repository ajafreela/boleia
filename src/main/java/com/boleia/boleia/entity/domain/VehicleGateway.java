package com.boleia.boleia.entity.domain;

import java.util.List;

import com.boleia.boleia.shared.types.Result;

public interface VehicleGateway {
    Result<List<VehicleOutput>, Void> findAll();
    Result<VehicleOutput, VehicleNotFoundError> findById(String id);
    Result<VehicleOutput, VehicleNotFoundError> findByPlate(String plate);
}
