package com.boleia.boleia.infra.shared.Exception;

import com.boleia.boleia.infra.shared.error.DomainError;

public class MissingFieldException extends DomainError{

    public MissingFieldException(String message) {
        super(message);
    }

}