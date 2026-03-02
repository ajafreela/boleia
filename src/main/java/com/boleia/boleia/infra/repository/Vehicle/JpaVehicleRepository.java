package com.boleia.boleia.infra.repository.Vehicle;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.boleia.boleia.infra.entity.Vehicle.VehicleEntity;

public interface JpaVehicleRepository extends JpaRepository<VehicleEntity, UUID>, JpaSpecificationExecutor<VehicleEntity>{}
