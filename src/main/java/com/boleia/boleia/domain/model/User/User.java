package com.boleia.boleia.domain.model.User;

import java.time.LocalDateTime;
import java.util.UUID;

import com.boleia.boleia.domain.Exception.MissingFieldException;
import com.boleia.boleia.domain.model.User.dto.UpdateUserDto;

import lombok.*;

public class User {
    
    @Getter
    private UUID id;

    @Getter
    private String firstName;
    
    @Getter
    private String lastName;
    
    @Getter
    private String phoneNumber;

    @Getter
    private UserType type;

    private EntityStatus status;

    @Getter
    private LocalDateTime createdAt;

    @Getter
    private LocalDateTime updatedAt;

    public User(UUID id, String firstName, String lastName, String phoneNumber, UserType type) {
        this(id, firstName, lastName, phoneNumber, type, EntityStatus.PENDING);
    }

    public User(UUID id, String firstName, String lastName, String phoneNumber, UserType type, EntityStatus status) {
     
        if(firstName == null || firstName.isBlank()) {
            throw new MissingFieldException("First name must be provided");
        }

        if(lastName == null || lastName.isBlank()) {
            throw new MissingFieldException("Last name must be provided");
        }

        if(phoneNumber == null || phoneNumber.isBlank()) {
            throw new MissingFieldException("Phone number must be provided");
        }

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.status = status != null ? status : EntityStatus.PENDING;
    }

    public User withUpdatedFields(UpdateUserDto dto) {
        return new User(
            this.id,
            dto.firstName() != null && !dto.firstName().isBlank() ? dto.firstName() : this.firstName,
            dto.lastName() != null && !dto.lastName().isBlank() ? dto.lastName() : this.lastName,
            dto.phoneNumber() != null && !dto.phoneNumber().isBlank() ? dto.phoneNumber() : this.phoneNumber,

            dto.type()
        );
    }

    public EntityStatus isActive() {
        return this.status;
    }

    public boolean isSuspend() {
        if(this.status.equals(EntityStatus.SUSPEND)) {
            return true;
        }
        return false;
    }

    public User changeStatus(EntityStatus status){
        return new User(id, firstName, lastName, phoneNumber, type, status);
    }

    
}
