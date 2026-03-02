package com.boleia.boleia.shared.jpa.entity;

import com.boleia.boleia.entity.domain.EntityType;
import com.boleia.boleia.shared.jpa.models.BaseModel;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity(name = "users")
public class UserModel extends BaseModel {
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private EntityType type;
    
    @Column(name = "status")
    private String status;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private DriverModel driver;

    public boolean isDriver() {
        return this.type == EntityType.DRIVER;
    }

}
