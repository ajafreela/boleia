package com.boleia.boleia.infra.repository.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.boleia.boleia.domain.model.User.Driver;
import com.boleia.boleia.infra.entity.User.DriverEntity;

public interface DriverProtocol {
    
    Driver save(Driver driver);
    List<?> findAll();
    Optional<DriverEntity> findById(UUID id);
    void delete(UUID id);
    Driver update(UUID id, Driver newDriver); 

}
