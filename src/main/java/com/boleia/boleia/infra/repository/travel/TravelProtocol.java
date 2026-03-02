package com.boleia.boleia.infra.repository.travel;

import java.util.List;
import java.util.UUID;

import com.boleia.boleia.domain.model.travel.Travel;
import com.boleia.boleia.infra.repository.travel.schema.TravelResponse;
import com.boleia.boleia.infra.shared.Exception.CustomNotFoundException;
import com.boleia.boleia.infra.shared.types.Result;

public interface TravelProtocol {
    UUID save(Travel entity);
    List<TravelResponse> findAll();
    Result<Travel, CustomNotFoundException> findByIdTravel(UUID id);
}
