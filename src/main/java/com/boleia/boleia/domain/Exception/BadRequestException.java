package com.boleia.boleia.domain.Exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message){
        super(message);
    }
    
}
