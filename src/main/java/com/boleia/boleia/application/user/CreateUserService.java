package com.boleia.boleia.application.user;

import java.util.UUID;

import com.boleia.boleia.application.Notification.OtpService;
import com.boleia.boleia.domain.Exception.ConflictExecption;
import com.boleia.boleia.domain.model.User.User;
import com.boleia.boleia.domain.model.User.UserType;
import com.boleia.boleia.infra.repository.User.UserProtocol;

public class CreateUserService {

    // private final UserProtocol repository;
    // private final OtpService otpService;

    // public CreateUserService(
    //     UserProtocol repository,
    //     OtpService otpService
    // ) {
    //     this.repository = repository;
    //     this.otpService = otpService;
    // }

    // public User execute(String firstName, String lastName, String phoneNumber, boolean isDriver) {
        
    //     this.repository.findByPhoneNumber(phoneNumber).ifPresent(u -> {
    //         throw new ConflictExecption("Phone number is already exists");
    //     });

    //     var userId = UUID.randomUUID();

    //     UserType type = null;

    //     if(isDriver == true) {
    //         type = UserType.DRIVER;
    //     } else {
    //         type = UserType.NORMAL;
    //     }

    //     User user = new User(userId, firstName, lastName, phoneNumber, type);
    //     this.repository.save(user);
    //     this.otpService.sendOtp(phoneNumber);
        
    //     return user;

    // }
    
}
