package com.boleia.boleia.travel.infra.postgres;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.boleia.boleia.shared.jpa.entity.TravelModel;
import com.boleia.boleia.shared.jpa.entity.TravelModelJpa;
import com.boleia.boleia.shared.jpa.entity.TravelPassangerModel;
import com.boleia.boleia.shared.jpa.entity.UserModel;
import com.boleia.boleia.shared.types.Result;
import com.boleia.boleia.travel.domain.PassengerOutput;
import com.boleia.boleia.travel.domain.TravelGateway;
import com.boleia.boleia.travel.domain.TravelNotFoundError;
import com.boleia.boleia.travel.domain.TravelOutput;
import com.boleia.boleia.travel.domain.TravelPassangerStatus;
import com.boleia.boleia.travel.domain.TravelStatus;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PostgresSQLTravelGateway implements TravelGateway {
    private final TravelModelJpa jpa;

    @Override
    public Result<List<TravelOutput>, Void> findAll() {
        var model = this.jpa.findAll();
        var out = model.stream().map(this::toOutput).toList();
        return Result.ok(out);
    }

    @Override
    public Result<TravelOutput, TravelNotFoundError> findById(String id) {
        var model = this.jpa.findById(id);
        return model.isPresent()
            ? Result.ok(this.toOutput(model.get()))
            : Result.error(new TravelNotFoundError());
    }

    @Override
    public Result<List<TravelOutput>, Void> findAllDriver(String id) {
        var model = this.jpa.findAllByDriverId(id);
        var out = model.stream().map(this::toOutput).toList();
        return Result.ok(out);
    }

    private TravelOutput toOutput(TravelModel model) {
        var availablePassangers = model.getPassengers().stream()
            .filter(ps -> ps.getStatus().equals(TravelPassangerStatus.ACCEPTED.getValue()))
            .map(ps -> toPassengerOutput(ps.getPassenger(), ps))
            .toList();

        var pendingPassangers = model.getPassengers().stream()
            .filter(ps -> ps.getStatus().equals(TravelPassangerStatus.ACCEPTED.getValue()))
            .map(ps -> toPassengerOutput(ps.getPassenger(), ps))
            .toList();

        return new TravelOutput(
            model.getId(),
            UUID.fromString(model.getVehicle().getId()),
            UUID.fromString(model.getDriver().getId()),
            model.getStartTime().toString(),
            TravelStatus.fromValue(model.getStatus()),
            model.getPrice(),
            model.getOrigin(),
            model.getDestiny(),
            model.getSeats(),
            model.getSeats(),
            availablePassangers,
            pendingPassangers,
            model.getCreatedAt().toString(),
            model.getUpdatedAt().toString()
        );
    }

    private PassengerOutput toPassengerOutput(UserModel model, TravelPassangerModel travelPassangerModel){
        return new PassengerOutput(
            model.getId(), 
            model.getFirstName(), 
            model.getLastName(), 
            model.getPhoneNumber(), 
            travelPassangerModel.getStatus(), 
            travelPassangerModel.getCreatedAt().toString()
        );
    }
    
}
