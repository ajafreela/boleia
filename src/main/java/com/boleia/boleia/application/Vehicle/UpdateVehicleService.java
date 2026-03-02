package com.boleia.boleia.application.Vehicle;

import java.util.UUID;

import com.boleia.boleia.domain.Exception.CustomNotFoundException;
import com.boleia.boleia.domain.model.Vehicle.Vehicle;
import com.boleia.boleia.domain.model.Vehicle.dto.UpdateVehicleDto;
import com.boleia.boleia.infra.repository.Vehicle.VehicleProtocol;

public class UpdateVehicleService {

    // private final VehicleProtocol protocol;

    // public UpdateVehicleService(
    //     VehicleProtocol protocol
    // ) {
    //     this.protocol = protocol;
    // }

    // public Vehicle execute(UUID id, UpdateVehicleDto req) {

    //     var existvehicle = this.protocol.findById(id).orElseThrow(() -> new CustomNotFoundException("Vehicle not found"));

    //     if(existvehicle.getDriver() == null) {
    //         throw new CustomNotFoundException("This vehicle have not driver allowed");
    //     }

    //     Vehicle entity = new Vehicle(
    //         existvehicle.getId(),
    //         req.plate(),
    //         req.brand(),
    //         req.color(),
    //         req.seats(),
    //         existvehicle.getDriver().getId()
    //     );

    //     return this.protocol.update(id, entity);


    // }
    
}
