package com.boleia.boleia.application.user;

import java.util.Optional;
import java.util.UUID;

import com.boleia.boleia.domain.Exception.CustomNotFoundException;
import com.boleia.boleia.infra.repository.User.DriverRepository;

public class FindDriverByIdService {

    // private final DriverRepository repository;

    // public FindDriverByIdService(DriverRepository repository) {
    //     this.repository = repository;
    // }

    // public Optional<?> execute(UUID id) {

    //     var existDriver = this.repository.findById(id);
        
    //     if(existDriver.isEmpty()) {
    //         throw new CustomNotFoundException("Driver not found");
    //     }

    //     return existDriver;

    // }
    
}
