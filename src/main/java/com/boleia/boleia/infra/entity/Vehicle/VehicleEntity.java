package com.boleia.boleia.infra.entity.Vehicle;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.boleia.boleia.domain.model.Vehicle.VehicleStatus;
import com.boleia.boleia.infra.entity.User.DriverEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class VehicleEntity {

    public VehicleEntity(UUID id, String plate, String brand, String color, String seats, VehicleStatus status) {
        this.id = id;
        this.plate = plate;
        this.brand = brand;
        this.color = color;
        this.seats = seats;
        this.status = status;
    }
    
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "plate")
    private String plate;
    
    @Column(name = "brand", nullable = true)
    private String brand;
    
    @Column(name = "color", nullable = true)
    private String color;
    
    @Column(name = "seats")
    private String seats;
    
    @Column(name = "status")
    private VehicleStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinColumn(name = "driver_id", referencedColumnName = "id", nullable = true, foreignKey = @ForeignKey(name = "fk_vehicle_driver"))
    private DriverEntity driver;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
