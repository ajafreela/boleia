package com.boleia.boleia.entity.domain;

import java.util.regex.Pattern;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.boleia.boleia.domain.Exception.BadRequestException;
import com.boleia.boleia.domain.Exception.MissingFieldException;

public class Password {
    
    private static final Pattern ONLY_NUMBERS = Pattern.compile("\\d{6}");
    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    public String fromPlainText(String rawPassword) {
        
        if(rawPassword == null) {
            throw new MissingFieldException("Password must be provided");
        }

        if(!ONLY_NUMBERS.matcher(rawPassword).matches()) {
            throw new BadRequestException("Password must have 6 digits");
        }


        return ENCODER.encode(rawPassword);
    }

    public Boolean matches(String rawPassword, String hashedPassword) {

        if (rawPassword == null || hashedPassword == null){
            throw new MissingFieldException("Both raw and hash password must be provided");
        }

        return ENCODER.matches(rawPassword, hashedPassword);
    }

}
