package com.boleia.boleia.application.travel;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.boleia.boleia.application.travel.input.RequestTripInput;
import com.boleia.boleia.domain.model.travel.TravelGateway;
import com.boleia.boleia.domain.model.travel.TravelPassanger;
import com.boleia.boleia.domain.model.travel.TravelPassangerRepository;
import com.boleia.boleia.domain.model.travel.TravelPassangerStatus;
import com.boleia.boleia.infra.repository.User.UserRepository;
import com.boleia.boleia.infra.shared.Exception.CustomNotFoundException;
import com.boleia.boleia.infra.shared.Exception.MissingFieldException;
import com.boleia.boleia.infra.shared.error.DomainError;
import com.boleia.boleia.infra.shared.types.Result;

import lombok.RequiredArgsConstructor;

// @Service
// @RequiredArgsConstructor
public class RequestTrip {

    // final TravelPassangerRepository repository;
    // final TravelGateway travelGateway;
    // final UserRepository passangerRepository;

    // public Result<Void, DomainError> execute(RequestTripInput input) {

    //     if(input.passangerId() == null) return Result.error(new MissingFieldException("Passenger id can not be null"));
    //     if(input.travelId() == null) return Result.error(new MissingFieldException("Travel id can not be null"));

    //     var travelOrErr = this.travelGateway.findById(input.travelId());
    //     if(travelOrErr.isError()) return Result.error(travelOrErr.unwraprror());

    //     var passengerOrErr = this.passangerRepository.findById(input.passangerId());
    //     if(passengerOrErr.getClass().equals(CustomNotFoundException.class)) {
    //         return Result.error(new CustomNotFoundException("Passanger not found"));
    //     }

    //     var travel = TravelPassanger.create(
    //         UUID.randomUUID(), 
    //         travelOrErr.unwrap().id(), 
    //         passengerOrErr.get().getId(), 
    //         TravelPassangerStatus.PENDING);

    //     this.repository.save(travel);

    //     return Result.ok(null);
    // }
    
}
