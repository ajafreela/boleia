package com.boleia.boleia.application.Notification;

import com.boleia.boleia.domain.Exception.CustomNotFoundException;
import com.boleia.boleia.domain.Exception.MissingFieldException;
import com.boleia.boleia.domain.model.Notification.OTPEntry;
import com.boleia.boleia.domain.model.Notification.dto.ValidationOtpDto;
import com.boleia.boleia.infra.repository.notification.InMemoryOtpRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidationOtpService {

    // private final InMemoryOtpRepository repository;

    // public ValidationOtpService(InMemoryOtpRepository repository) {
    //     this.repository = repository;
    // }

    // public boolean execute(ValidationOtpDto input){

    //     if(input.phoneNumber() == null || input.otp() == null) {
    //         throw new MissingFieldException("Verify you payload");
    //     }

    //     OTPEntry entry = repository.findByPhoneNumber(input.phoneNumber());

    //     if(entry == null) {
    //         throw new CustomNotFoundException("Otp not found");
    //     }

    //     if(entry.isExpired()){
    //         throw new CustomNotFoundException("Otp expired");
    //     }

    //     boolean valid = entry.getOtp().equals(input.otp());

    //     if(!valid) {
    //         throw new CustomNotFoundException("OTP is diferent");
    //     }

    //     return valid;

    // }
    
}
