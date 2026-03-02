package com.boleia.boleia.domain.model.Vehicle;

import java.util.UUID;

import com.boleia.boleia.domain.Exception.MissingFieldException;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Vehicle {
    
    private UUID id;
    
    private String plate;
    
    private String brand;
    
    private String color;
    
    private String seats;
    
    @Setter
    private VehicleStatus status;

    @Getter
    private UUID driverId;

    public Vehicle(UUID id, String plate, String brand, String color, String seats, UUID driverId) {
        this(id, plate, brand, color, seats, driverId, VehicleStatus.PENDING);
    }

    public Vehicle(UUID id, String plate, String brand, String color, String seats, UUID driverId, VehicleStatus status) {

        if(plate == null || plate.isBlank()){
            throw new MissingFieldException("Plate must be provided");
        }

        if(brand == null || brand.isBlank()){
            throw new MissingFieldException("Brand must be provided");
        }
        
        if(color == null || color.isBlank()){
            throw new MissingFieldException("Color be provided");
        }
        
        if(seats == null || seats.isBlank()){
            throw new MissingFieldException("Seats be provided");
        }

        this.id = id;
        this.plate = plate;
        this.brand = brand;
        this.color = color;
        this.seats = seats;
        this.driverId = driverId;
        this.status = status != null ? status : VehicleStatus.PENDING;

    }

    public VehicleStatus isActive(){
        return this.status;
    }


}
