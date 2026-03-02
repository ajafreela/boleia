package com.boleia.boleia.application.user;

import java.util.UUID;
import com.boleia.boleia.domain.model.Password;
import com.boleia.boleia.domain.model.User.Driver;
import com.boleia.boleia.domain.model.User.User;
import com.boleia.boleia.infra.repository.User.DriverProtocol;

import jakarta.transaction.Transactional;

public class CreateDriverService {

    // private final CreateUserService createUserService;
    // private final DriverProtocol driverProtocol;

    // public CreateDriverService(CreateUserService createUserService, DriverProtocol driverProtocol){
    //     this.createUserService = createUserService;
    //     this.driverProtocol = driverProtocol;
    // }

    // @Transactional
    // public Driver execute( String firstName, String lastName, String phoneNumber, String identificationNumber, String password, String licenseNumber, Boolean isDriver ) {
        
    //     UUID driverId = UUID.randomUUID();

    //     User user = this.createUserService.execute(firstName, lastName, phoneNumber, true);

    //     Password aPassword = new Password();

    //     String hashedPassword = aPassword.fromPlainText(password);
        
    //     Driver driverObject = new Driver(driverId, identificationNumber, hashedPassword, licenseNumber, user);
        
    //     var created = this.driverProtocol.save(driverObject);
        
    //     return created;
        
    // }
    
}
