package com.boleia.boleia.domain.model.travel;

import java.util.UUID;

import com.boleia.boleia.infra.repository.travel.schema.TravelResponse;
import com.boleia.boleia.infra.shared.Exception.CustomNotFoundException;
import com.boleia.boleia.infra.shared.types.Result;

public interface TravelGateway {
    Result<TravelResponse, CustomNotFoundException> findById(UUID id);
    Result<TravelResponse, CustomNotFoundException> findTravelPassengerById(UUID id);
}
