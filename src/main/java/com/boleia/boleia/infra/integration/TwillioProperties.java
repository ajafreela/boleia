package com.boleia.boleia.infra.integration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "twilio")
public class TwillioProperties {

    @Getter
    @Setter
    private String accountSid;
    @Getter
    @Setter
    private String authToken;
    @Getter
    @Setter
    private String fromPhone;
    
}
