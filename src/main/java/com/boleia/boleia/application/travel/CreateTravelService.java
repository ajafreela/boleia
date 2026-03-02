package com.boleia.boleia.application.travel;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.boleia.boleia.domain.Exception.CustomNotFoundException;
import com.boleia.boleia.domain.model.Vehicle.Vehicle;
import com.boleia.boleia.domain.model.travel.Travel;
import com.boleia.boleia.domain.model.travel.TravelRepository;
import com.boleia.boleia.domain.model.travel.dto.CreateTravelDto;
import com.boleia.boleia.infra.entity.Vehicle.VehicleEntity;
import com.boleia.boleia.infra.repository.Vehicle.VehicleProtocol;
import com.boleia.boleia.infra.shared.error.DomainError;
import com.boleia.boleia.infra.shared.types.Result;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// @Slf4j
// @Service
// @RequiredArgsConstructor
public class CreateTravelService {
    
    // final TravelRepository repository;
    // final VehicleProtocol vehicleProtocol;

    // public Result<Void, DomainError> execute(CreateTravelDto input) {

    //     VehicleEntity vehicleEntity = this.vehicleProtocol.findById(input.vehicleId()).orElseThrow(() -> new CustomNotFoundException("Vehicle not found"));
        
    //     Vehicle vehicle = new Vehicle(
    //         vehicleEntity.getId(), 
    //         vehicleEntity.getPlate(),
    //         vehicleEntity.getBrand(),
    //         vehicleEntity.getColor(),
    //         vehicleEntity.getSeats(),
    //         input.driverId()
    //     );

    //     var travel = Travel.create(
    //         vehicle.getId(), 
    //         input.timeToTravel(), 
    //         input.dateToTravel(), 
    //         new BigDecimal(input.price()), 
    //         input.origin(), 
    //         input.destiny()
    //     );

    //     this.repository.save(travel);

    //     return Result.ok(null);

    // }

}
