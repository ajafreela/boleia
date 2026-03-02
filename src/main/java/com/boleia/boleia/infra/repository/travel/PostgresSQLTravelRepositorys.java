package com.boleia.boleia.infra.repository.travel;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.boleia.boleia.domain.Exception.CustomNotFoundException;
import com.boleia.boleia.domain.model.travel.Travel;
import com.boleia.boleia.domain.model.travel.TravelRepository;
import com.boleia.boleia.infra.entity.travel.TravelEntity;
import com.boleia.boleia.infra.entity.travel.TravelModelJpas;
import com.boleia.boleia.infra.repository.travel.schema.TravelResponse;
import com.boleia.boleia.infra.shared.error.DomainError;
import com.boleia.boleia.infra.shared.types.Result;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Slf4j
public class PostgresSQLTravelRepositorys implements TravelRepository {

    private final TravelModelJpas jpa;

    @Override
    public Result<Void, DomainError> save(Travel input) {
        TravelEntity model;
        
        if(input.getId() != null) {
            var existing = this.jpa.findById(input.getId());
            if(existing.isPresent()) {
                model = existing.get();
            } else {
                model = new TravelEntity();
                model.setId(input.getId());
            }
        } else {
            model = new TravelEntity();
        }

        model.setOrigin(null);
        model.setDestiny(null);
        model.setPrice(null);
        model.setSeats(null);
        model.setVehicle(null);

        try {
            this.jpa.save(model);
            return Result.ok(null);
        } catch (Exception e) {
            var msg = "Error when create a travel";
            log.error(msg, e);
            Result.error(new DomainError(msg));
        }

        return null;
        
    }

    @Override
    public Result<TravelEntity, CustomNotFoundException> findById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public List<TravelResponse> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Result<Travel, CustomNotFoundException> findByIdTravel(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByIdTravel'");
    }
}
