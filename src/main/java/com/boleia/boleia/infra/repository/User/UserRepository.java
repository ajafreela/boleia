package com.boleia.boleia.infra.repository.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.boleia.boleia.domain.Exception.CustomNotFoundException;
import com.boleia.boleia.domain.model.User.User;
import com.boleia.boleia.infra.entity.User.UserEntity;
import com.boleia.boleia.infra.repository.User.schema.UserResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UserRepository implements UserProtocol {
    
    private final JpaUserRepository jpa;

    public UserRepository(JpaUserRepository jpa) {
        this.jpa = jpa;
    }

    public User toDomain (UserEntity e) {
        return new User(e.getId(), e.getFirstName(), e.getLastName(), e.getPhoneNumber(), e.getType());
    }

    public UserEntity toEntity(User e){
        return new UserEntity(e.getId(), e.getFirstName(), e.getLastName(), e.getPhoneNumber(), e.getType(), e.isActive(), null);
    }

    // @Override
    public User save(User user) {
        
        UserEntity entity = new UserEntity(
            user.getId(),
            user.getFirstName(),
            user.getLastName(),
            user.getPhoneNumber(),
            user.getType(),
            user.isActive(),
            null
        );

        var saved = jpa.save(entity);
            
        return toDomain(saved);
    }

    public List<UserResponse> findAll() {
        return jpa.findAll()
            .stream()
            .map( e ->
                new UserResponse(e.getId(), e.getFirstName(), e.getLastName(), e.getPhoneNumber(), e.getType(), e.getStatus(), e.getCreatedAt(), e.getUpdatedAt(), e.getDriver())
            )
            .collect(Collectors.toList());
    }

    public Optional<User> findByPhoneNumber(String phone) {

        return jpa.findByPhoneNumber(phone).map(this::toDomain);

    }

    public void delete(UUID id){

        jpa.findById(id).orElseThrow(() -> new CustomNotFoundException("User not found"));

        jpa.deleteById(id);
    }

    public Optional<UserEntity> findById(UUID id) {

        return jpa.findById(id);
            // .map(e -> new UserEntity(e.getId(), e.getFirstName(), e.getLastName(), e.getPhoneNumber(), e.getType(), e.getDriver()));

    }

    public User update(UUID id, User request) {

        UserEntity entity = new UserEntity();

        entity.setId(id);
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setPhoneNumber(request.getPhoneNumber());
        entity.setStatus(request.isActive());
        entity.setType(request.getType());

        var saved = jpa.save(entity);

        return this.toDomain(saved);

    }


}
