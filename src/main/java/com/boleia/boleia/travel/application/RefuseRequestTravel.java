package com.boleia.boleia.travel.application;

import org.springframework.stereotype.Service;

import com.boleia.boleia.shared.error.DomainError;
import com.boleia.boleia.shared.types.Result;
import com.boleia.boleia.travel.domain.TravelIsFuelError;
import com.boleia.boleia.travel.domain.TravelPassangerStatus;
import com.boleia.boleia.travel.domain.TravelRepository;
import com.boleia.boleia.travel.domain.user.UserACL;
import com.boleia.boleia.travel.domain.user.UserNotFoundError;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RefuseRequestTravel {
    private final TravelRepository repository;
    private final UserACL userACL;

    public Result<Void, DomainError> execute(RefuseRequestTravelInput input){
        var travelOrErr = this.repository.findById(input.travelId());
        if(travelOrErr.isError()) return Result.error(travelOrErr.unwrapError());

        var travel = travelOrErr.unwrap().getPassangers().stream().filter(ps -> ps.getPassangerId().equals(input.passangerId())).toList();
        if(travel.isEmpty()) return Result.error(new UserNotFoundError());

        var acceptedCount = travelOrErr.unwrap().getPassangers().stream().filter(ps -> ps.getStatus().equals(TravelPassangerStatus.ACCEPTED)).count();
        if(acceptedCount >= travelOrErr.unwrap().getSeats()) return Result.error(new TravelIsFuelError());




        var passagerOrErr = this.userACL.findById(input.passangerId());
        if(passagerOrErr.isError()) return Result.error(passagerOrErr.unwrapError());

        var voidOrErr = this.repository.save(null);
        if(voidOrErr.isError()) return Result.error(voidOrErr.unwrapError());

        return Result.ok(null);
    }

}
