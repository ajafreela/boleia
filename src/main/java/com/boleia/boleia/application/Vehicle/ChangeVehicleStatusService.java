package com.boleia.boleia.application.Vehicle;

import java.util.UUID;

import com.boleia.boleia.domain.Exception.CustomNotFoundException;
import com.boleia.boleia.domain.model.Vehicle.Vehicle;
import com.boleia.boleia.domain.model.Vehicle.VehicleStatus;
import com.boleia.boleia.domain.model.Vehicle.dto.ChangeVehicleStatusDto;
import com.boleia.boleia.infra.repository.Vehicle.VehicleProtocol;

public class ChangeVehicleStatusService {
    
    // private final VehicleProtocol protocol;

    // public ChangeVehicleStatusService(
    //     VehicleProtocol protocol
    // ) {
    //     this.protocol = protocol;
    // }

    // public VehicleStatus execute(UUID id, ChangeVehicleStatusDto status) {

    //     var existVehicle = this.protocol.findById(id).orElseThrow(() -> new CustomNotFoundException("Vehicle not found"));

    //     if(existVehicle.getDriver() == null) {
    //         throw new CustomNotFoundException("This vehicle have not driver allowed");
    //     }

    //     Vehicle vehicle = new Vehicle(
    //         id,
    //         existVehicle.getPlate(),
    //         existVehicle.getBrand(),
    //         existVehicle.getColor(),
    //         existVehicle.getSeats(),
    //         existVehicle.getDriver().getId()
    //     );

    //     vehicle.setStatus(status.status());

    //     this.protocol.update(id, vehicle);

    //     return status.status();
    // }

}
