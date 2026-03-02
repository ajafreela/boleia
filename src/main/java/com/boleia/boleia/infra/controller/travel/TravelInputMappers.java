package com.boleia.boleia.infra.controller.travel;

import org.springframework.stereotype.Component;

import com.boleia.boleia.application.travel.input.RequestTripInput;

@Component
public class TravelInputMappers {
    public RequestTripInput toRequestTripInput(com.boleia.boleia.infra.controller.travel.input.RequestTripInput body){
        return new RequestTripInput(body.travelId(), body.passangerId());
    }
}
