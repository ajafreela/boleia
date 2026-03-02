package com.boleia.boleia.domain.model.travel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.boleia.boleia.domain.model.User.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Travel {
    
    private UUID id;
    private UUID vehicleId;
    private String timeToTravel;
    private String dateToTravel;
    TravelStatus status;
    private BigDecimal price;
    private String origin;
    private String destiny;
    private List<String> stops;
    private List<User> passenger;

    public static Travel create(
        UUID vehicleId,
        String timeToTravel,
        String dateToTravel,
        BigDecimal price,
        String origin,
        String destiny
    ) {

        return new Travel(
            UUID.randomUUID(),
            vehicleId, 
            timeToTravel, 
            dateToTravel, 
            TravelStatus.OPEN,
            price,
            origin,
            destiny,
            new ArrayList<>(),
            new ArrayList<>()
        );
    }

    public Travel from(
        UUID id,
        UUID vehicleId,
        String timeToTravel,
        String dateToTravel,
        TravelStatus status,
        BigDecimal price,
        String origin,
        String destiny,
        List<String> stops,
        List<User> passenger
    ) {
        return new Travel(
            id,
            vehicleId,
            timeToTravel,
            dateToTravel,
            status,
            price,
            origin,
            destiny,
            stops,
            passenger
        );
    }

    public void finishTravel() {
        this.status = TravelStatus.COMPLETED;
    }

    public void fuelTravel() {
        this.status = TravelStatus.FUEL;
    }

    public void startTravel() {
        this.status = TravelStatus.STARTED;
    }

}
