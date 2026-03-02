package com.boleia.boleia.infra.repository.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.boleia.boleia.domain.Exception.CustomNotFoundException;
import com.boleia.boleia.domain.model.User.Driver;
import com.boleia.boleia.domain.model.User.User;
import com.boleia.boleia.infra.entity.User.DriverEntity;
import com.boleia.boleia.infra.entity.User.UserEntity;
import com.boleia.boleia.infra.repository.User.schema.DriverResponse;

@Repository
public class DriverRepository implements DriverProtocol {

    private final JpaDriverRepository jpa;
    private final UserRepository userRepositoryImpl;

    public DriverRepository(
        JpaDriverRepository jpa,
        UserRepository userRepositoryImpl
    ){
        this.jpa = jpa;
        this.userRepositoryImpl = userRepositoryImpl;
    }

    public Driver toDomain(DriverEntity e){

        User user = e.getUser() != null ? userRepositoryImpl.toDomain(e.getUser()) : null;

        return new Driver(e.getId(), e.getIdentificationNumber(), e.getPassword(), e.getLicenseNumber(), user);
    }

    public DriverEntity toEntity(Driver e){
        UserEntity user = e.getUser() != null ? userRepositoryImpl.toEntity(e.getUser()) : null;
        return new DriverEntity(e.getId(), e.getIdentificationNumber(), e.getPassword(), e.getLicenseNumber(), user);
    }

    public Driver save(Driver driver) {

        DriverEntity saved = jpa.save(toEntity(driver));
        
        return toDomain(saved);

    }

    public List<DriverResponse> findAll() {
        return jpa.findAll()
            .stream()
            .map(e ->
                new DriverResponse(e.getId(), e.getIdentificationNumber(), e.getLicenseNumber(), e.getCreatedAt(), e.getUpdatedAt())
            ).collect(Collectors.toList());
    }

    public Optional<DriverEntity> findById(UUID id) {

        return this.jpa.findById(id);

    }

    public Driver update(UUID id, Driver request) {

        return this.save(request);

    }

    public void delete(UUID id) {

        this.jpa.findById(id).orElseThrow(() -> new CustomNotFoundException("Driver not found"));

        this.jpa.deleteById(id);

    }
    
}
