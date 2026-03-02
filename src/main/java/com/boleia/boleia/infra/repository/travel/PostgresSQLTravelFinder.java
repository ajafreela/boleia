package com.boleia.boleia.infra.repository.travel;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.boleia.boleia.domain.model.Vehicle.Vehicle;
import com.boleia.boleia.domain.model.travel.TravelPassanger;
import com.boleia.boleia.infra.entity.Vehicle.VehicleEntity;
import com.boleia.boleia.infra.entity.travel.TravelEntity;
import com.boleia.boleia.infra.entity.travel.TravelPassangerModel;
import com.boleia.boleia.infra.entity.travel.TravelPassangerModelJpa;
import com.boleia.boleia.infra.repository.travel.schema.TravelResponse;
import com.boleia.boleia.infra.shared.Exception.CustomNotFoundException;
import com.boleia.boleia.infra.shared.types.Result;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PostgresSQLTravelFinder implements TravelGateways {
    final JpaTravelRepository jpa;
    final TravelPassangerModelJpa travelPassangerModelJpa;


    @Override
    public Result<TravelResponse, CustomNotFoundException> findById(UUID id) {

        var model = this.jpa.findById(id);

        return model.isPresent() 
                ? Result.ok(this.toTravelResponse(model.get())) 
                : Result.error(new CustomNotFoundException("Sem viagem pendentee"));

    }

    private TravelResponse toTravelResponse(TravelEntity model) {
        return new TravelResponse(
            model.getId(),
            this.toVehicle(model.getVehicle()),
            model.getStartTime(),
            model.getStatus(),
            null,
            model.getPrice(),
            model.getDestiny(),
            model.getStops());
    }

    private Vehicle toVehicle(VehicleEntity model) {
        return new Vehicle(
            model.getId(),
            model.getPlate(),
            model.getBrand(),
            model.getColor(),
            model.getSeats(),
            null);
    }

    @Override
    public Result<TravelPassanger, CustomNotFoundException> findTravelPassengerById(UUID id) {
        var model = this.travelPassangerModelJpa.findById(id);
        return model.isPresent() ?
                Result.ok(this.toTravelPassangerModel(model.get()))
                : Result.error(new CustomNotFoundException("Sem solicitações de viagen"));
    }

    private TravelPassanger toTravelPassangerModel(TravelPassangerModel model) {
        var travel = new TravelPassanger(null, model.getId(), model.getTravelId().getId(), model.getPassangerId().getId());
        return travel;
    }


}
