package com.boleia.boleia.infra.entity.travel;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.boleia.boleia.domain.model.travel.TravelStatus;
import com.boleia.boleia.infra.entity.User.UserEntity;
import com.boleia.boleia.infra.entity.Vehicle.VehicleEntity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Table(name = "travels")
@Getter
@Setter
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class TravelEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @ManyToOne(optional = false)
    private VehicleEntity vehicle;
    
    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;
    
    @Enumerated(EnumType.STRING)
    private TravelStatus status;
    
    @ManyToMany
    private List<UserEntity> passenger;
    
    @Column(name = "price", nullable = false)
    private String price;
    
    @Column(name = "origin", nullable = false)
    private String origin;

    @Column(name = "destiny", nullable = false)
    private String destiny;

    @Column(name = "seats", nullable = false)
    private String seats;
    
    @ElementCollection
    private List<String> stops;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
