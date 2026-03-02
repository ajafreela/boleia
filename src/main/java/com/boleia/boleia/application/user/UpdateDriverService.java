package com.boleia.boleia.application.user;

import java.util.UUID;

import com.boleia.boleia.domain.Exception.CustomNotFoundException;
import com.boleia.boleia.domain.model.User.Driver;
import com.boleia.boleia.domain.model.User.User;
import com.boleia.boleia.domain.model.User.UserType;
import com.boleia.boleia.domain.model.User.dto.UpdateDriverDto;
import com.boleia.boleia.infra.repository.User.DriverProtocol;
import com.boleia.boleia.infra.repository.User.UserProtocol;

import lombok.extern.slf4j.Slf4j;

// @Slf4j
public class UpdateDriverService {

    // private final DriverProtocol driverRepository;
    // private final UserProtocol userProtocol;


    // public UpdateDriverService(DriverProtocol driverRepository, UserProtocol userProtocol) {
    //     this.driverRepository = driverRepository;
    //     this.userProtocol = userProtocol;
    // }

    // public UUID execute(UUID id, UpdateDriverDto newInformation) {
        
    //     var existDriver = this.driverRepository.findById(id).orElseThrow(() -> new CustomNotFoundException("Driver not found"));

    //     var userId = existDriver.getUser().getId();

    //     this.userProtocol.findById(userId).orElseThrow(() -> new CustomNotFoundException("User not found")); 
        
    //     var type = UserType.DRIVER;

    //     User aUser = new User(userId, newInformation.firstName(), newInformation.lastName(), newInformation.phoneNumber(), type);

    //     Driver aDriver = new Driver(id, newInformation.identificationNumber(), existDriver.getPassword(), newInformation.licenseNumber(), aUser);

    //     this.userProtocol.update(userId, aUser);

    //     this.driverRepository.update(userId, aDriver);

    //     return id;
    // }
    
}
