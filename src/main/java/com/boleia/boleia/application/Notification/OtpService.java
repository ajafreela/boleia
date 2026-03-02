package com.boleia.boleia.application.Notification;

import com.boleia.boleia.domain.model.Notification.OTPEntry;
import com.boleia.boleia.domain.model.Notification.OtpProtocol;
import com.boleia.boleia.infra.repository.notification.InMemoryOtpRepository;

public class OtpService {

    // private final OtpProtocol otpProtocol;
    // private final InMemoryOtpRepository repository;

    // public OtpService(OtpProtocol otpProtocol, InMemoryOtpRepository repository) {
    //     this.otpProtocol = otpProtocol;
    //     this.repository = repository;
    // }

    // public void sendOtp(String phone){

    //     String otp = this.generateOpt();

    //     long expiredAt = System.currentTimeMillis() + (5 * 60 * 1000);

    //     OTPEntry entry = new OTPEntry(otp, phone, expiredAt);
    //     repository.save(entry);

    //     this.otpProtocol.send(phone, otp);

    // }

    // private String generateOpt(){
    //     String otp = String.valueOf((int) (Math.random() * 900000) + 100000);
    //     return otp;
    // }


    
}
