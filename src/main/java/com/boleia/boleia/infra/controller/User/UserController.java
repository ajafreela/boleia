package com.boleia.boleia.infra.controller.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boleia.boleia.application.user.CreateUserService;
import com.boleia.boleia.application.user.DeleteUserService;
import com.boleia.boleia.application.user.FindUserByIdService;
import com.boleia.boleia.application.user.ListUserService;
import com.boleia.boleia.application.user.UpdateUserService;
import com.boleia.boleia.domain.model.User.dto.CreateAccountUser;
import com.boleia.boleia.domain.model.User.dto.UpdateUserDto;
import com.boleia.boleia.infra.entity.User.UserEntity;
import com.boleia.boleia.infra.repository.User.schema.UserResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




// @RestController
// @RequestMapping("/boleia/api/v1")
// @Tag(name = "User", description = "User management")
public class UserController {

    // private final CreateUserService createUser;
    // private final ListUserService listUser;
    // private final DeleteUserService deleteUser;
    // private final UpdateUserService updateUserService;
    // private final FindUserByIdService findByUserService;

    // public UserController(
    //     CreateUserService createUser,
    //     ListUserService listUser,
    //     DeleteUserService deleteUserService,
    //     UpdateUserService updateUserService,
    //     FindUserByIdService findUserByIdService
    //     ){
    //     this.createUser = createUser;
    //     this.listUser = listUser;
    //     this.deleteUser = deleteUserService;
    //     this.updateUserService = updateUserService;
    //     this.findByUserService = findUserByIdService;
    // }
    
    // @PostMapping("user")
    // public UUID create(@RequestBody CreateAccountUser user) {
    //     var created = this.createUser.execute(user.firstName(), user.lastName(), user.phoneNumber(), user.isDriver());
    //     return created.getId();
    // }

    // @GetMapping("user")
    // public List<UserResponse> findAll() {
    //     return this.listUser.execute();
    // }

    // @DeleteMapping("user/{id}")
    // public void delete(@PathVariable UUID id){
    //     this.deleteUser.execute(id);
    // }

    // @PatchMapping("user/{id}")
    // public UUID update(@PathVariable UUID id, @RequestBody UpdateUserDto request){

    //     return this.updateUserService.execute(id, request);

    // }

    // @GetMapping("user/{id}")
    // public Optional<UserEntity> findById(@PathVariable UUID id) {
    //     return this.findByUserService.execute(id);
    // }

    // @PatchMapping("user/toggle-status/{id}")
    // public void toggleStatus(@PathVariable UUID id) {
    //     this.updateUserService.toggleStatus(id);
    // }

    // @PatchMapping("user/suspend-user/{id}")
    // public void postMethodName(@PathVariable UUID id) {
    //     this.updateUserService.suspendUser(id);
    // }
    

}


