package com.boleia.boleia.domain.model.User;

import java.time.LocalDateTime;
import java.util.UUID;

import com.boleia.boleia.domain.Exception.MissingFieldException;
import com.boleia.boleia.domain.model.User.dto.UpdateDriverDto;

import lombok.Getter;

public class Driver {

    @Getter
    private UUID id;

    @Getter
    private String identificationNumber;
    
    @Getter
    private String password;

    @Getter
    private String licenseNumber;

    @Getter
    private LocalDateTime createdAt;

    @Getter
    private LocalDateTime updatedAt;
    
    @Getter
    private User user;

    public Driver( UUID id, String identificationNumber, String password, String licenseNumber, User user ){

        this.id = id;
        this.identificationNumber = identificationNumber;
        this.password = password;
        this.licenseNumber = licenseNumber;
        this.user = user;

    }

    public static Driver create(String identificationNumber, String password, String licenseNumber, User user){

        if(identificationNumber == null || identificationNumber.isBlank()) {
            throw new MissingFieldException("Identification Number must be provided");
        }

        if(password == null || password.isBlank()) {
            throw new MissingFieldException("Password must be provided");
        }

        if(licenseNumber == null || licenseNumber.isBlank()) {
            throw new MissingFieldException("License Number must be provided");
        }

        return new Driver(null, identificationNumber, password, licenseNumber, user);

    }

    public Driver withUpdateFields(UpdateDriverDto dto) {
        return new Driver(
            this.id,
            
            dto.identificationNumber() != null && !dto.identificationNumber().isBlank() ? dto.identificationNumber() : this.identificationNumber,

            this.password,
            
            dto.licenseNumber() != null && !dto.licenseNumber().isBlank() ? dto.licenseNumber() : this.licenseNumber,
            
            this.user
            
        );
    }


    
}
