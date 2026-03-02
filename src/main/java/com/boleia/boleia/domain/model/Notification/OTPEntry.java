package com.boleia.boleia.domain.model.Notification;

import lombok.Getter;

public class OTPEntry {
    
    @Getter
    private final String otp;
    @Getter
    private final String phoneNumber;
    @Getter
    private final long expiredAt;
    
    public OTPEntry(String otp, String phoneNumber, long expiredAt){
        this.otp = otp;
        this.phoneNumber = phoneNumber;
        this.expiredAt = expiredAt;
    }

    public boolean isExpired(){
        return System.currentTimeMillis() > expiredAt;
    }


}
