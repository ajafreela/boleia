package com.boleia.boleia.infra.repository.Vehicle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.boleia.boleia.domain.model.Vehicle.Vehicle;
import com.boleia.boleia.infra.entity.Vehicle.VehicleEntity;
import com.boleia.boleia.infra.repository.Vehicle.schema.VehicleResponse;

public interface VehicleProtocol {
    Vehicle save(Vehicle input);
    List<VehicleResponse> findAll();
    Optional<VehicleEntity> findById(UUID id);
    Vehicle update(UUID id, Vehicle req);
}
