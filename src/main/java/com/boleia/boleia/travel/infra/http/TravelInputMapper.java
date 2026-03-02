package com.boleia.boleia.travel.infra.http;

import org.springframework.stereotype.Component;

import com.boleia.boleia.travel.application.CreateTravelInput;

@Component
public class TravelInputMapper {
    
    public CreateTravelInput toCreateTravelInput(CreateTravelRequest body) {
        return new CreateTravelInput(body.vehicleId(), body.driverId(), body.dateToTravel(), body.price(), body.origin(), body.destiny(), body.seats());
    }

}
