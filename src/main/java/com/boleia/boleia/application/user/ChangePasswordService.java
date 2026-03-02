package com.boleia.boleia.application.user;

import java.util.UUID;

import com.boleia.boleia.domain.Exception.BadRequestException;
import com.boleia.boleia.domain.Exception.CustomNotFoundException;
import com.boleia.boleia.domain.model.Password;
import com.boleia.boleia.domain.model.User.Driver;
import com.boleia.boleia.domain.model.User.User;
import com.boleia.boleia.domain.model.User.dto.ChangePasswordDto;
import com.boleia.boleia.infra.repository.User.DriverProtocol;

public class ChangePasswordService {
    
    // private final DriverProtocol protocol;

    // public ChangePasswordService(DriverProtocol protocol) {
    //     this.protocol = protocol;
    // }

    // public Driver execute(UUID id, ChangePasswordDto password) {

    //     var existDriver = this.protocol.findById(id).orElseThrow(() -> new CustomNotFoundException("Driver not found"));

    //     Password aPassword = new Password();

    //     if(!password.oldPassword().equals(password.confirmPassword())) {
    //         throw new BadRequestException("current password and confirm password are not the same");
    //     }

    //     var passwordMatched = aPassword.matches(password.oldPassword(), existDriver.getPassword());
        
    //     if(!passwordMatched) {
    //         throw new BadRequestException("Current password is wrong ");
    //     }

    //     String hashedPassword = aPassword.fromPlainText(password.newPassword()); 

    //     User user = new User(existDriver.getUser().getId(), existDriver.getUser().getFirstName(), existDriver.getUser().getLastName(), existDriver.getUser().getPhoneNumber(), existDriver.getUser().getType());

    //     Driver newDriver = new Driver(id, existDriver.getIdentificationNumber(), hashedPassword, existDriver.getLicenseNumber(), user);

    //     this.protocol.update(id, newDriver);

    //     return newDriver;

    // }

}
