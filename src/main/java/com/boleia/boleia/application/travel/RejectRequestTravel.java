package com.boleia.boleia.application.travel;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.boleia.boleia.domain.model.travel.TravelPassangerRepository;
import com.boleia.boleia.infra.shared.error.DomainError;
import com.boleia.boleia.infra.shared.types.Result;

import lombok.RequiredArgsConstructor;

// @Service
// @RequiredArgsConstructor
public class RejectRequestTravel {
    // final TravelPassangerRepository repository;

    // public Result<Void, DomainError> execute(UUID requestTravelId) {
        
    //     var travelPassangerOrErr = this.repository.findById(requestTravelId);
    //     if(travelPassangerOrErr.isError()) return Result.error(travelPassangerOrErr.unwraprror());

    //     var travelApprove = travelPassangerOrErr.unwrap();
    //     travelApprove.reject();;

    //     var voidOrErr = this.repository.save(travelApprove);
    //     if(voidOrErr.isError()) return Result.error(voidOrErr.unwraprror());

    //     return Result.ok(null);
    // }

}
