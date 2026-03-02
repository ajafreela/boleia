package com.boleia.boleia.application.Vehicle;

import java.util.UUID;

import com.boleia.boleia.domain.Exception.BadRequestException;
import com.boleia.boleia.domain.Exception.CustomNotFoundException;
import com.boleia.boleia.domain.model.Vehicle.Vehicle;
import com.boleia.boleia.domain.model.Vehicle.dto.CreateVehicleDto;
import com.boleia.boleia.infra.entity.Vehicle.VehicleEntity;
import com.boleia.boleia.infra.repository.User.DriverProtocol;
import com.boleia.boleia.infra.repository.Vehicle.VehicleProtocol;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateVehicleService {

    // private final VehicleProtocol protocol;
    // private final DriverProtocol driverProtocol;

    // public CreateVehicleService(
    //     VehicleProtocol protocol,
    //     DriverProtocol driverProtocol
    // ) {
    //     this.protocol = protocol;
    //     this.driverProtocol = driverProtocol;
    // }

    // public UUID execute(CreateVehicleDto input) {

    //     var driverExist = this.driverProtocol.findById(input.driverId()).orElseThrow(() -> new CustomNotFoundException("Driver not found"));
        
    //     if(driverExist.getVehicles().size() == 4) {
    //         throw new BadRequestException("Driver just have 4 car");
    //     }

    //     UUID id = UUID.randomUUID();
        
    //     driverExist.setId(input.driverId());

    //     VehicleEntity ve = new VehicleEntity();
    //     ve.setId(id);
    //     ve.setPlate(input.plate());
    //     ve.setBrand(input.brand());
    //     ve.setColor(input.color());
    //     ve.setSeats(input.seats());
    //     ve.setDriver(driverExist);
        
    //     var req = new Vehicle(ve.getId(), ve.getPlate(), ve.getBrand(), ve.getColor(), ve.getSeats(), driverExist.getId());
        
    //     this.protocol.save(req);

    //     return id;

    // }
    
}
