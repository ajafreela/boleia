package com.boleia.boleia.application.user;

import java.util.Optional;
import java.util.UUID;

import com.boleia.boleia.domain.Exception.CustomNotFoundException;
import com.boleia.boleia.infra.entity.User.UserEntity;
import com.boleia.boleia.infra.repository.User.UserProtocol;

public class FindUserByIdService {
    
    // private final UserProtocol repository;

    // public FindUserByIdService(UserProtocol repository) {
    //     this.repository = repository;
    // }

    // public Optional<UserEntity> execute(UUID id) {

    //     var existUser = this.repository.findById(id);
    //     if(existUser.isEmpty()) {
    //         throw new CustomNotFoundException("User not found");
    //     }

    //     return existUser;

    // }

}
