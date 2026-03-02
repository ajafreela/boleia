package com.boleia.boleia.infra.shared.Exception;


import com.boleia.boleia.infra.shared.error.DomainError;

public class ConflictExecption extends DomainError {
    
    public ConflictExecption(String message){
        super(message);
    }

}
