package com.boleia.boleia.application.travel;

import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.boleia.boleia.domain.model.travel.TravelGateway;
import com.boleia.boleia.infra.entity.travel.TravelPassangerModel;
import com.boleia.boleia.infra.entity.travel.TravelPassangerResponse;
import com.boleia.boleia.infra.repository.travel.TravelPassangerGateway;
import com.boleia.boleia.infra.repository.travel.schema.TravelResponse;
import com.boleia.boleia.infra.shared.Exception.CustomNotFoundException;
import com.boleia.boleia.infra.shared.types.Pagination;
import com.boleia.boleia.infra.shared.types.Result;

import lombok.RequiredArgsConstructor;

// @Service
// @RequiredArgsConstructor
public class TravelFinder {
    // final TravelGateway gateway;
    // final TravelPassangerGateway travelPassangerGateway;

    // public Result<TravelResponse, CustomNotFoundException> findById(UUID id) {
    //     return this.gateway.findById(id);
    // }

    // public Result<TravelResponse, CustomNotFoundException> findTravelPassangerById(UUID id) {
    //     return this.gateway.findTravelPassengerById(id);
    // }

    //  public Pagination<TravelPassangerResponse> findAll(Specification<TravelPassangerModel> spec, Pageable pageable) {
    //     return travelPassangerGateway.findAll(spec, pageable);
    // }


}
