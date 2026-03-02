package com.boleia.boleia.infra.entity.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.boleia.boleia.infra.entity.Vehicle.VehicleEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "drivers")
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class DriverEntity {

    public DriverEntity(UUID id, String identificationNumber, String password, String licenseNumber, UserEntity user) {
        this.id = id;
        this.identificationNumber = identificationNumber;
        this.password = password;
        this.licenseNumber = licenseNumber;
        this.user = user;
    }
    
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "identification_number")
    private String identificationNumber;
    
    @Column
    private String password;
    
    @Column(nullable = false, name = "license_number")
    private String licenseNumber;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true, foreignKey = @ForeignKey(name = "fk_driver_user"))
    private UserEntity user;

    @OneToMany(mappedBy = "driver", cascade =  CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    // private List<VehicleEntity> vehicles = new ArrayList<>();
    private List<VehicleEntity> vehicles;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
