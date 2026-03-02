package com.boleia.boleia.infra.repository.Vehicle;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.boleia.boleia.domain.Exception.CustomNotFoundException;
import com.boleia.boleia.domain.model.Vehicle.Vehicle;
import com.boleia.boleia.infra.entity.User.DriverEntity;
import com.boleia.boleia.infra.entity.Vehicle.VehicleEntity;
import com.boleia.boleia.infra.repository.User.JpaDriverRepository;
import com.boleia.boleia.infra.repository.Vehicle.schema.VehicleResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class VehicleRepository implements VehicleProtocol {
    
    private final JpaVehicleRepository jpa;
    private final JpaDriverRepository driverRepository;

    public VehicleRepository(JpaVehicleRepository jpa, JpaDriverRepository driverRepository){
        this.jpa = jpa;
        this.driverRepository = driverRepository;
    }

    public Vehicle toDomain(VehicleEntity e) {

        return new Vehicle(e.getId(), e.getPlate(), e.getBrand(), e.getColor(), e.getColor(), null);
    }

    public VehicleEntity toEntity(Vehicle e, DriverEntity driverEntity) {
        var vehicle = new VehicleEntity(e.getId(), e.getPlate(), e.getBrand(), e.getColor(), e.getSeats(), e.getStatus());
        vehicle.setDriver(driverEntity);
        return vehicle;
    }

    public Vehicle save(Vehicle input) {

        VehicleEntity vehicle = new VehicleEntity();
        DriverEntity driver = this.driverRepository.findById(input.getDriverId()).orElseThrow(() -> new CustomNotFoundException("Driver not found"));

        vehicle.setBrand(input.getBrand());
        vehicle.setColor(input.getColor());
        vehicle.setId(input.getId());
        vehicle.setPlate(input.getPlate());
        vehicle.setSeats(input.getSeats());
        vehicle.setStatus(input.isActive());
        vehicle.setDriver(driver);

        var saved = this.jpa.save(vehicle);

        return toDomain(saved);

    }

    public List<VehicleResponse> findAll(){

        return this.jpa.findAll()
            .stream()
            .map(e -> 
                new VehicleResponse(e.getId(), e.getPlate(), e.getBrand(), e.getColor(), e.getSeats(), e.getStatus(), e.getCreatedAt(), e.getUpdatedAt())
            ).toList();

    }

    public Optional<VehicleEntity> findById(UUID id) {

        return this.jpa.findById(id);

    }

    public Vehicle update(UUID id, Vehicle req){

        VehicleEntity entity = new VehicleEntity();

        var driverExist = this.driverRepository.findById(req.getDriverId()).orElseThrow(() -> new CustomNotFoundException("Driver not found"));

        entity.setId(id);
        entity.setBrand(req.getBrand());
        entity.setColor(req.getColor());
        entity.setPlate(req.getPlate());
        entity.setSeats(req.getSeats());
        entity.setStatus(req.getStatus());
        entity.setDriver(driverExist);

        var saved = jpa.save(entity);
        return this.toDomain(saved);

    }


}
