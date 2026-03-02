package com.boleia.boleia.domain.Exception;

public class MissingFieldException extends RuntimeException{

    public MissingFieldException(String message) {
        super(message);
    }

}