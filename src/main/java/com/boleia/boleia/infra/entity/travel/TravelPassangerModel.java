package com.boleia.boleia.infra.entity.travel;

import com.boleia.boleia.infra.entity.User.UserEntity;
import com.boleia.boleia.infra.shared.models.BaseModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "travel_passenger")
public class TravelPassangerModel extends BaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "travel_id", nullable = false)
    private TravelEntity travelId;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passanger_id", nullable = false)
    private UserEntity passangerId;

    @Column(name = "status")
    private String status;

}
