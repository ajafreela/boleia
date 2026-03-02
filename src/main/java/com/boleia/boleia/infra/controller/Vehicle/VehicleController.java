package com.boleia.boleia.infra.controller.Vehicle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boleia.boleia.application.Vehicle.ChangeVehicleStatusService;
import com.boleia.boleia.application.Vehicle.CreateVehicleService;
import com.boleia.boleia.application.Vehicle.FindVehicleByIdService;
import com.boleia.boleia.application.Vehicle.ListVehicleService;
import com.boleia.boleia.application.Vehicle.UpdateVehicleService;
import com.boleia.boleia.domain.model.Vehicle.VehicleStatus;
import com.boleia.boleia.domain.model.Vehicle.dto.ChangeVehicleStatusDto;
import com.boleia.boleia.domain.model.Vehicle.dto.CreateVehicleDto;
import com.boleia.boleia.domain.model.Vehicle.dto.UpdateVehicleDto;
import com.boleia.boleia.infra.repository.Vehicle.schema.VehicleResponse;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


// @RestController
// @RequestMapping("/boleia/api/v1")
// @Tag(name = "Vehicle", description = "Vehicle management")
public class VehicleController {

    // private final CreateVehicleService createVehicleService;
    // private final ListVehicleService listVehicleService;
    // private final FindVehicleByIdService findVehicleByIdService;
    // private final UpdateVehicleService updateVehicleService;
    // private final ChangeVehicleStatusService changeVehicleStatusService;

    // public VehicleController(
    //     CreateVehicleService createVehicleService,
    //     ListVehicleService listVehicleService,
    //     FindVehicleByIdService findVehicleByIdService,
    //     UpdateVehicleService updateVehicleService,
    //     ChangeVehicleStatusService changeVehicleStatusService

    // ){
    //     this.createVehicleService = createVehicleService;
    //     this.listVehicleService = listVehicleService;
    //     this.findVehicleByIdService = findVehicleByIdService;
    //     this.updateVehicleService = updateVehicleService;
    //     this.changeVehicleStatusService = changeVehicleStatusService;
    // }

    // @PostMapping("vehicle")
    // public UUID create(@RequestBody CreateVehicleDto vehicleDto) {
        
    //     var res = this.createVehicleService.execute(vehicleDto);
    //     return res;
    // }

    // @GetMapping("vehicle")
    // public List<VehicleResponse> findAll() {
    //     return this.listVehicleService.execute();
    // }

    // @GetMapping("vehicle/{id}")
    // public VehicleResponse findById(@PathVariable UUID id) {

    //     var result = findVehicleByIdService.execute(id);

    //     var dto = new VehicleResponse(
    //         result.getId(),
    //         result.getPlate(),
    //         result.getBrand(),
    //         result.getColor(),
    //         result.getSeats(),
    //         result.getStatus(),
    //         result.getCreatedAt(),
    //         result.getUpdatedAt()
    //     );

    //     return dto; 
    // }

    // @PatchMapping("vehicle/{id}")
    // public UUID update(@PathVariable UUID id, @RequestBody UpdateVehicleDto entity) {
        
    //     var res = this.updateVehicleService.execute(id, entity);

    //     return res.getId(); 
    // }

    // @PutMapping("vehicle/status/toggle/{id}")
    // public VehicleStatus toggleStatus(@PathVariable UUID id, @RequestBody ChangeVehicleStatusDto status) {

    //     var res = this.changeVehicleStatusService.execute(id, status);

    //     return res;
    // }
    
    
    
    
}
