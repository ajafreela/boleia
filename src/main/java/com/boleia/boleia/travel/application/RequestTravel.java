package com.boleia.boleia.travel.application;

import org.springframework.stereotype.Service;

import com.boleia.boleia.shared.error.DomainError;
import com.boleia.boleia.shared.types.Result;
import com.boleia.boleia.travel.domain.TravelIsFuelError;
import com.boleia.boleia.travel.domain.TravelRepository;
import com.boleia.boleia.travel.domain.user.UserACL;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RequestTravel {
    private final TravelRepository repository;
    private final UserACL userACL;


    public Result<Void, DomainError> execute(RequestTravelInput input){
        var userOrErr = this.userACL.findById(input.passangerId());
        if(userOrErr.isError()) return Result.error(userOrErr.unwrapError());

        var travelOrErr = this.repository.findById(input.travelId());
        if(travelOrErr.isError()) return Result.error(travelOrErr.unwrapError());
        if(travelOrErr.unwrap().isFuel()) return Result.error(new TravelIsFuelError());

        var travel = travelOrErr.unwrap();

        travel.requestTravel(userOrErr.unwrap().getId());

        var voidOrErr = this.repository.save(travel);
        if(voidOrErr.isError()) return Result.error(voidOrErr.unwrapError());

        return Result.ok(null);
    }
}
