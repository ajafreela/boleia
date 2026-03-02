package com.boleia.boleia.infra.repository.travel;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.boleia.boleia.domain.model.User.User;
import com.boleia.boleia.domain.model.Vehicle.Vehicle;
import com.boleia.boleia.domain.model.travel.TravelGateway;
import com.boleia.boleia.domain.model.travel.TravelPassanger;
import com.boleia.boleia.infra.entity.User.UserEntity;
import com.boleia.boleia.infra.entity.Vehicle.VehicleEntity;
import com.boleia.boleia.infra.entity.travel.TravelEntity;
import com.boleia.boleia.infra.entity.travel.TravelPassangerModel;
import com.boleia.boleia.infra.entity.travel.TravelPassangerModelJpa;
import com.boleia.boleia.infra.repository.travel.schema.TravelResponse;
import com.boleia.boleia.infra.shared.Exception.CustomNotFoundException;
import com.boleia.boleia.infra.shared.types.Result;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
@RequiredArgsConstructor
public class PostgresSQLTravelGateways implements TravelGateway {
    
    final JpaTravelRepository jpa;
    final TravelPassangerModelJpa travelPassangerModelJpa;
    
    @Override
    public Result<TravelResponse, CustomNotFoundException> findById(UUID id) {

        var model = this.jpa.findById(id);
        return model.isPresent()
            ? Result.ok(toTravelResponse(model.get()))
            : Result.error(new CustomNotFoundException("Travel not Found"));
    }

    private TravelResponse toTravelResponse(TravelEntity model) {

        return new TravelResponse(
            model.getId(), 
            this.toVehicle(model.getVehicle()), 
            model.getStartTime(), 
            model.getStatus(),
            model.getPassenger().stream().map(this::toPassanger).toList(), 
            model.getPrice(), 
            model.getDestiny(), 
            null
        );

    }

    private Vehicle toVehicle(VehicleEntity input) {
        return new Vehicle(
            input.getId(),
            input.getPlate(),
            input.getBrand(),
            input.getColor(),
            input.getSeats(),
            input.getDriver().getId());
    }

    private User toPassanger(UserEntity input) {
        return new User(
            input.getId(),
            input.getFirstName(),
            input.getLastName(),
            input.getPhoneNumber(),
            input.getType());
    }

    @Override
    public Result<TravelResponse, CustomNotFoundException> findTravelPassengerById(UUID id) {
        var model = this.travelPassangerModelJpa.findById(id);
        return model.isPresent() ?
                Result.ok(this.toTravelResponse(model.get()))
                : Result.error(new CustomNotFoundException("Sem solicitações de viagen"));
    }

    private TravelPassanger toTravelPassangerModel(TravelPassangerModel model) {
        var travel = new TravelPassanger(null, model.getId(), model.getTravelId().getId(), model.getPassangerId().getId());
        return travel;
    }

    private TravelResponse toTravelResponse(TravelPassangerModel model) {
        
        var travel = this.jpa.findById(model.getTravelId().getId()).get();

        var travelPassenger = this.travelPassangerModelJpa.findByTravelId_id(model.getId());

        var t = this.travelPassangerModelJpa.findAll().stream().filter(c -> c.getTravelId().getId().equals(model.getTravelId().getId())).toList();

        var pss = travel.getPassenger().stream().map(this::toPassanger).toList();

        var p = t.stream().map(null);

        return new TravelResponse(
            model.getId(),
            null, 
            // this.toVehicle(travel.getVehicle()),
            model.getTravelId().getStartTime(), 
            model.getTravelId().getStatus(), 
            null, 
            model.getTravelId().getPrice(),
            model.getTravelId().getDestiny(),
            model.getTravelId().getStops());
    }

    private List<User> toPassangerDomainList(List<TravelPassangerModel> passengers) {
    return passengers.stream()
        .map(p -> new User(p.getPassangerId().getId(), null, null, null, null))
        .toList();
}


}
