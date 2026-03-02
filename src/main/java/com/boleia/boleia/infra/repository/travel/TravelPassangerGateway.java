package com.boleia.boleia.infra.repository.travel;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.boleia.boleia.infra.entity.travel.TravelPassangerModel;
import com.boleia.boleia.infra.entity.travel.TravelPassangerResponse;
import com.boleia.boleia.infra.shared.types.Pagination;

public interface TravelPassangerGateway {
    Pagination<TravelPassangerResponse> findAll(
      Specification<TravelPassangerModel> spec, Pageable pageable);
}
