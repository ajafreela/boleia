package com.boleia.boleia.infra.repository.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.boleia.boleia.domain.model.User.User;
import com.boleia.boleia.infra.entity.User.UserEntity;
import com.boleia.boleia.infra.repository.User.schema.UserResponse;

public interface UserProtocol {
    
    User save(User user);
    List<UserResponse> findAll();
    Optional<User> findByPhoneNumber(String phone);
    void delete(UUID id);
    User update(UUID id, User request);
    Optional<UserEntity> findById(UUID id);

}
