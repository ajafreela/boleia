package com.boleia.boleia.domain.model.travel;

import java.util.List;
import java.util.UUID;

import com.boleia.boleia.domain.Exception.CustomNotFoundException;
import com.boleia.boleia.infra.entity.travel.TravelEntity;
import com.boleia.boleia.infra.repository.travel.schema.TravelResponse;
import com.boleia.boleia.infra.shared.error.DomainError;
import com.boleia.boleia.infra.shared.types.Result;

public interface TravelRepository {
    Result<Void, DomainError> save(Travel travel);
    Result<TravelEntity, CustomNotFoundException> findById(UUID id);
    List<TravelResponse> findAll();
    Result<Travel, CustomNotFoundException> findByIdTravel(UUID id);
}
