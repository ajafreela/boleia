package com.boleia.boleia.application.user;

import java.util.UUID;

import com.boleia.boleia.domain.Exception.ConflictExecption;
import com.boleia.boleia.domain.Exception.CustomNotFoundException;
import com.boleia.boleia.domain.model.User.User;
import com.boleia.boleia.domain.model.User.EntityStatus;
import com.boleia.boleia.domain.model.User.dto.UpdateUserDto;
import com.boleia.boleia.infra.repository.User.UserProtocol;

public class UpdateUserService {

    // private final UserProtocol repository;

    // public UpdateUserService(UserProtocol repository) {
    //     this.repository = repository;
    // }

    // public UUID execute(UUID id, UpdateUserDto request) {

    //     var existingEntity = this.repository.findById(id).orElseThrow(() -> 
    //         new CustomNotFoundException("User not found")
    //     );

    //     User existingUser = new User(
    //         existingEntity.getId(),
    //         existingEntity.getFirstName(),
    //         existingEntity.getLastName(),
    //         existingEntity.getPhoneNumber(),
    //         existingEntity.getType()
    //     );


    //     if(request.phoneNumber() != null) {
    //         this.repository.findByPhoneNumber(request.phoneNumber())
    //         .filter(u -> !u.getId().equals(id))
    //         .ifPresent(u -> { throw new ConflictExecption("Phone number is already exists"); });
    //     }

    //     User updatedUser = existingUser.withUpdatedFields(request);
        
    //     var response = this.repository.update(id, updatedUser);

    //     if(response == null) {
    //         throw new CustomNotFoundException("Error updating user - repository returned null");
    //     }

    //     return response.getId();

    // }

    // public void toggleStatus(UUID id) {

    //     var existUser = repository.findById(id).orElseThrow(() -> new CustomNotFoundException("User not found"));

    //     UserStatus status = existUser.getStatus() != UserStatus.ACTIVE ? UserStatus.ACTIVE : UserStatus.PENDING;

    //     User user = new User(
    //         existUser.getId(), 
    //         existUser.getFirstName(), 
    //         existUser.getLastName(), 
    //         existUser.getPhoneNumber(), 
    //         existUser.getType(), 
    //         status
    //     );

    //     repository.update(id, user);

    // }

    // public void suspendUser(UUID id) {
    //     var existingUser = repository.findById(id).orElseThrow(() -> new CustomNotFoundException("User not found"));

    //     UserStatus status = UserStatus.SUSPEND;

    //     User user = new User(
    //         existingUser.getId(), 
    //         existingUser.getFirstName(), 
    //         existingUser.getLastName(), 
    //         existingUser.getPhoneNumber(), 
    //         existingUser.getType(), 
    //         status
    //     );

    //     repository.update(id, user);



    // }
    
}
