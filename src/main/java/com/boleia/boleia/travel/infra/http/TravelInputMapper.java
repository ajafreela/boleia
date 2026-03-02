package com.boleia.boleia.travel.infra.http;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.boleia.boleia.travel.application.CreateTravelInput;
import com.boleia.boleia.travel.application.RequestTravelInput;

@Component
public class TravelInputMapper {
    
    public CreateTravelInput toCreateTravelInput(CreateTravelRequest body) {
        return new CreateTravelInput(body.vehicleId(), body.driverId(), body.dateToTravel(), body.price(), body.origin(), body.destiny(), body.seats());
    }

    public RequestTravelInput toRequestTravelInput(TravelRequest body) {
        return new RequestTravelInput(UUID.fromString(body.travelId()), UUID.fromString(body.passangerId()));
    }

}
