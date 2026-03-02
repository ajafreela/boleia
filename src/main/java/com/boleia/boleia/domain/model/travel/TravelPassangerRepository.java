package com.boleia.boleia.domain.model.travel;

import java.util.UUID;

import com.boleia.boleia.infra.shared.Exception.CustomNotFoundException;
import com.boleia.boleia.infra.shared.error.DomainError;
import com.boleia.boleia.infra.shared.types.Result;

public interface TravelPassangerRepository {
    Result<Void, DomainError> save(TravelPassanger input);
    Result<TravelPassanger, CustomNotFoundException> findById(UUID id);
}
