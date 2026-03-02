package com.boleia.boleia.infra.shared.Exception;

import com.boleia.boleia.infra.shared.error.DomainError;

public class CustomNotFoundException extends DomainError {
    
    public CustomNotFoundException(String message) {
        super(message);
    }

}
