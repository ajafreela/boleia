package com.boleia.boleia.infra.repository.travel;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.boleia.boleia.domain.model.travel.TravelPassanger;
import com.boleia.boleia.domain.model.travel.TravelPassangerRepository;
import com.boleia.boleia.domain.model.travel.TravelRepository;
import com.boleia.boleia.infra.entity.User.UserEntity;
import com.boleia.boleia.infra.entity.travel.TravelEntity;
import com.boleia.boleia.infra.entity.travel.TravelPassangerModel;
import com.boleia.boleia.infra.entity.travel.TravelPassangerModelJpa;
import com.boleia.boleia.infra.repository.User.UserRepository;
import com.boleia.boleia.infra.shared.Exception.CustomNotFoundException;
import com.boleia.boleia.infra.shared.error.DomainError;
import com.boleia.boleia.infra.shared.types.Result;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Slf4j
public class PostgresSQLTravelPassangerRepository implements TravelPassangerRepository {

    final TravelPassangerModelJpa jpa;
    final TravelRepository travelRepository;
    final UserRepository userRepository;

    @Override
    public Result<Void, DomainError> save(TravelPassanger input) {

        TravelPassangerModel model;

        if (input.getUuid() != null) {
        var existing = this.jpa.findById(input.getUuid());
        if (existing.isPresent()) {
                model = existing.get();
            } else {
                model = new TravelPassangerModel();
                model.setId(input.getUuid());
            }
        } else {
            model = new TravelPassangerModel();
        }

        model.setPassangerId(toPassanger(input.getPassangerId()));
        model.setTravelId(toTravelModel(input.getTravelId()));
        model.setStatus(input.getStatus().getValue());

        try {
            this.jpa.save(model);
            return Result.ok(null);
        } catch (Exception e) {
            var msg = "Erro ao solicitar boleia";
            log.error(msg, e);
            Result.error(new DomainError(msg));
        }

        return null;
    }

    private TravelEntity toTravelModel(UUID id) {
        var model = new TravelEntity();
        var m = this.travelRepository.findById(id);
        model.setId(m.unwrap().getId());
        return model;
    }

    private UserEntity toPassanger(UUID id) {
        var model = new UserEntity();
        var m = this.userRepository.findById(id).get();
        model.setId(m.getId());
        return model;
    }

    @Override
    public Result<TravelPassanger, CustomNotFoundException> findById(UUID id) {
      
        var modelOrEmpty = this.jpa.findById(id);

        if(modelOrEmpty.isEmpty()) return Result.error(new CustomNotFoundException("Request not found"));
        
        return Result.ok(toTravelPassangerResponse(modelOrEmpty.get()));

    }

    private TravelPassanger toTravelPassangerResponse(TravelPassangerModel model){
        return new TravelPassanger(
            0L, 
            model.getId(), 
            model.getTravelId().getId(), 
            model.getPassangerId().getId());
    }
}
