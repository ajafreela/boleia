package com.boleia.boleia.infra.shared.Exception;

import com.boleia.boleia.infra.shared.error.DomainError;

public class BadRequestException extends DomainError {

    public BadRequestException(String message){
        super(message);
    }
    
}
