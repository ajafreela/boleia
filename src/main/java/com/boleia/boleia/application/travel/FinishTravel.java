package com.boleia.boleia.application.travel;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.boleia.boleia.domain.model.travel.TravelRepository;
import com.boleia.boleia.infra.repository.travel.TravelProtocol;
import com.boleia.boleia.infra.shared.error.DomainError;
import com.boleia.boleia.infra.shared.types.Result;

import lombok.RequiredArgsConstructor;

// @Service
// @RequiredArgsConstructor
public class FinishTravel {
    // final TravelRepository protocol;
    
    // public Result<Void, DomainError> execute(UUID travelId) {

    //     var travelOrErr = this.protocol.findByIdTravel(travelId);
    //     // if(travelOrErr.isError()) return Result.error(travelOrErr.unwraprror());

    //     var travelFinish = travelOrErr.unwrap();
    //     travelFinish.finishTravel();

    //     try {
    //         this.protocol.save(travelFinish);
    //         return Result.ok(null);
    //     } catch (Exception e) {
    //         return Result.error(new DomainError("Erro ao finalizar a corrida"));
    //     }

    // }

}
