package com.boleia.boleia.infra.integration;

import com.boleia.boleia.domain.model.Notification.OtpProtocol;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import lombok.Getter;

@Getter
public class TwillioOtpSender implements OtpProtocol {
    
    private final String accountSid;
    private final String authToken;
    private final String fromPhone;

    public TwillioOtpSender(String accountSid, String authToken, String fromPhone){
        this.accountSid = accountSid;
        this.authToken = authToken;
        this.fromPhone = fromPhone;
        Twilio.init(accountSid, authToken);
    }

    public void send(String to, String otp) {
        this.sendOtp(to, otp);
    }

    @Override
    public void sendOtp(String to, String otp){
        Message.creator(
            new com.twilio.type.PhoneNumber(to),
            "MG7ee018d9daf6d33c77e91d9a85b46229",
            "Código de validação: " + otp
        ).create();
    }

}
