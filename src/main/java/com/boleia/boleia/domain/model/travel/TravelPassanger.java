package com.boleia.boleia.domain.model.travel;

import java.util.UUID;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TravelPassanger {
    final Long id;
    final UUID uuid;
    final UUID travelId;
    final UUID passangerId;
     TravelPassangerStatus status;

    private TravelPassanger(
        Long id,
        UUID uuid,
        UUID travelId,
        UUID passangerid,
        TravelPassangerStatus status
    ) {
        this.id = id;
        this.uuid = uuid;
        this.travelId = travelId;
        this.passangerId = passangerid;
        this.status = status;
    }

    public static TravelPassanger create(
        UUID uuid,
        UUID travelId,
        UUID passanger,
        TravelPassangerStatus status
    ){
        return new TravelPassanger(
            0L,
            uuid,
            travelId,
            passanger,
            status
        );
    }

    public static TravelPassanger from(
        Long id,
        UUID uuid,
        UUID travelId,
        UUID passanger,
        TravelPassangerStatus status
    ){
        return new TravelPassanger(
            id,
            uuid,
            travelId,
            passanger,
            status
        );
    }

    public void approve() {
        this.status = TravelPassangerStatus.APPROVED;
    }

    public void reject() {
        this.status = TravelPassangerStatus.REJECTED;
    }
    
}
