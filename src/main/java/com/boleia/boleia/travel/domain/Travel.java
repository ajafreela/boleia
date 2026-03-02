package com.boleia.boleia.travel.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;

@Getter
public class Travel {
    private UUID id;
    private UUID vehicleId;
    private UUID driverId;
    private String dateToTravel;
    TravelStatus status;
    private BigDecimal price;
    private String origin;
    private String destiny;
    private Integer seats;
    private List<String> stops;
    private List<TravelPassanger> passangers;

    public Travel(
        UUID id,
        UUID vehicleId,
        UUID driverId,
        String dateToTravel,
        TravelStatus status,
        BigDecimal price,
        String origin,
        String destiny,
        Integer seats,
        List<TravelPassanger> passangers
    ) {
        this.id = id;
        this.vehicleId =  vehicleId;
        this.driverId = driverId;
        this.dateToTravel = dateToTravel;
        this.status = status;
        this.price = price;
        this.origin = origin;
        this.destiny = destiny;
        this.seats = seats;
        this.passangers = passangers;
    }

    public static Travel create(
        UUID vehicleId,
        UUID driverId,
        String dateToTravel,
        BigDecimal price,
        String origin,
        String destiny,
        Integer seats
    ) {

        return new Travel(
            UUID.randomUUID(),
            vehicleId, 
            driverId,
            dateToTravel, 
            TravelStatus.OPEN,
            price,
            origin,
            destiny,
            seats,
            new ArrayList<TravelPassanger>()
        );
    }

    public static Travel from(
        UUID id,
        UUID vehicleId,
        UUID driverId,
        String dateToTravel,
        TravelStatus status,
        BigDecimal price,
        String origin,
        String destiny,
        Integer seats
    ) {
        return new Travel(
            id,
            vehicleId,
            driverId,
            dateToTravel,
            status,
            price,
            origin,
            destiny,
            seats,
            new ArrayList<TravelPassanger>()
        );
    }

    public void requestTravel(UUID passangerId){
        this.passangers.add(TravelPassanger.create(passangerId));
    }

    public boolean isFuel(){
        return this.seats.equals(0);
    }

    public void decreseSeats(){
        this.seats = seats --;
    }

    public void finish() {
        this.status = TravelStatus.COMPLETED;
    }

    public void fuel() {
        this.status = TravelStatus.FUEL;
    }

    public void start() {
        this.status = TravelStatus.STARTED;
    }

    public void open(){
        this.status = TravelStatus.OPEN;
    }

    public void acceptPassenger(UUID passengerId) {
        var passenger = findPassenger(passengerId);
        
        // Regra: Só pode aceitar se houver assentos disponíveis
        long acceptedCount = this.passangers.stream()
                .filter(p -> p.getStatus() == TravelPassangerStatus.ACCEPTED)
                .count();

        if (acceptedCount >= this.seats) {
            throw new DomainError("Não há mais assentos disponíveis para esta boleia.");
        }

        passenger.setStatus(TravelPassangerStatus.ACCEPTED);
    }

    public void rejectPassenger(UUID passengerId) {
        var passenger = findPassenger(passengerId);
        passenger.setStatus(TravelPassangerStatus.REFUSED);
    }

    private TravelPassanger findPassenger(UUID passengerId) {
        return this.passangers.stream()
                .filter(p -> p.getPassangerId().equals(passengerId))
                .findFirst()
                .orElseThrow(() -> new DomainError("Passageiro não encontrado nesta requisição."));
    }

}
