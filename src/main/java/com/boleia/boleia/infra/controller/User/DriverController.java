package com.boleia.boleia.infra.controller.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boleia.boleia.application.user.ChangePasswordService;
import com.boleia.boleia.application.user.CreateDriverService;
import com.boleia.boleia.application.user.DeleteDriverService;
import com.boleia.boleia.application.user.FindDriverByIdService;
import com.boleia.boleia.application.user.ListDriverService;
import com.boleia.boleia.application.user.UpdateDriverService;
import com.boleia.boleia.domain.model.User.dto.ChangePasswordDto;
import com.boleia.boleia.domain.model.User.dto.CreateDriverDto;
import com.boleia.boleia.domain.model.User.dto.UpdateDriverDto;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;




// @RestController
// @RequestMapping("/boleia/api/v1")
// @Tag(name = "Driver", description = "Driver management")
public class DriverController {

    // private final CreateDriverService createDriver;
    // private final ListDriverService listDriver;
    // private final FindDriverByIdService findDriverById;
    // private final UpdateDriverService updateDriverService;
    // private final ChangePasswordService changePasswordService;
    // private final DeleteDriverService deleteDriverService;

    // public DriverController(
    //     CreateDriverService createDrive,
    //     ListDriverService listDriver,
    //     FindDriverByIdService findDriverById,
    //     UpdateDriverService updateDriverService,
    //     ChangePasswordService changePasswordService,
    //     DeleteDriverService deleteDriverService
    // ) {
    //     this.createDriver = createDrive;
    //     this.listDriver = listDriver;
    //     this.findDriverById = findDriverById;
    //     this.updateDriverService = updateDriverService;
    //     this.changePasswordService = changePasswordService;
    //     this.deleteDriverService = deleteDriverService;
    // }

    // @PostMapping("driver")
    // public UUID create(@RequestBody CreateDriverDto driver) {
        
    //     var created = this.createDriver.execute(driver.firstName(), driver.lastName(), driver.phoneNumber(), driver.identificationNumber(), driver.password(), driver.licenseNumber(), driver.isDriver());

    //     return created.getId();
    // }

    // @GetMapping("driver")
    // public List<?> findAll() {
    //     return listDriver.execute();
    // }

    // @GetMapping("driver/{id}")
    // public Optional<?> findById(@PathVariable UUID id) {
    //     return this.findDriverById.execute(id);
    // }

    // @PatchMapping("driver/{id}")
    // public UUID update(@PathVariable UUID id, @RequestBody UpdateDriverDto newInformation) {

    //     var respose = this.updateDriverService.execute(id, newInformation);

    //     return respose;

    // }

    // @DeleteMapping("driver/{id}")
    // public void delete(@PathVariable UUID id) {
    //     this.deleteDriverService.execute(id);
    // }
    
    // @PatchMapping("driver/change-password/{id}")
    // public UUID changePassword(@PathVariable UUID id, @RequestBody ChangePasswordDto password) {

    //     var respose = this.changePasswordService.execute(id, password);

    //     return respose.getId();

    // }

    
    
    
}
