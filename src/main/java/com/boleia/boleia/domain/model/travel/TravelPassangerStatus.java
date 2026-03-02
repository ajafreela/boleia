package com.boleia.boleia.domain.model.travel;

import lombok.Getter;

@Getter
public enum TravelPassangerStatus {
    PENDING("PENDING"),
    APPROVED("APPROVED"),
    REJECTED("REJECTED");

    final String value;

    TravelPassangerStatus(String value){
        this.value = value;
    }

    public static TravelPassangerStatus fromString(String value){

        if(value.equals(APPROVED.value)) return APPROVED;
        
        if(value.equals(REJECTED.value)) return REJECTED;

        if(value.equals(PENDING.value)) return PENDING;

        return PENDING;
    }

}
