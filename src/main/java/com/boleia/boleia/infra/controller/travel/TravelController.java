package com.boleia.boleia.infra.controller.travel;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boleia.boleia.application.travel.ApproveRequestTravel;
import com.boleia.boleia.application.travel.CreateTravelService;
import com.boleia.boleia.application.travel.FinishTravel;
import com.boleia.boleia.application.travel.ListTravelService;
import com.boleia.boleia.application.travel.RejectRequestTravel;
import com.boleia.boleia.application.travel.RequestTrip;
import com.boleia.boleia.application.travel.TravelFinder;
import com.boleia.boleia.domain.model.travel.dto.CreateTravelDto;
import com.boleia.boleia.infra.controller.travel.input.RequestTripInput;
import com.boleia.boleia.infra.handler.BoleiaHandler;
import com.boleia.boleia.infra.repository.travel.TravelQueryBuilder;
import com.boleia.boleia.infra.repository.travel.schema.TravelResponse;
import com.boleia.boleia.infra.shared.types.Paginator;
import com.boleia.boleia.infra.shared.types.Result;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


// @RestController
// @Validated
// @RequestMapping("/boleia/api/v1")
// @Tag(name = "Travel", description = "Travel management")
// @RequiredArgsConstructor
public class TravelController {

    // final CreateTravelService createTravelService;
    // final ListTravelService listTravelService;
    // final BoleiaHandler errorHandler;
    // final RequestTrip requestTrip;
    // final TravelInputMapper travelInputMapper;
    // final TravelFinder finder;
    // final ApproveRequestTravel approveRequest;
    // final RejectRequestTravel rejectRequestTravel;
    // final FinishTravel finishTravel;

    // @PostMapping("/travel")
    // public ResponseEntity<?> create(@RequestBody CreateTravelDto entity) {

    //     var out = this.createTravelService.execute(entity);

    //     return out.isOk() ? 
    //         ResponseEntity.ok(out.unwrap()) :
    //         errorHandler.handleDomain(out.unwraprror());
    // }

    // @GetMapping("/travel")
    // public List<TravelResponse> findAll() {
    //     return this.listTravelService.execute();
    // }

    // @PostMapping("/travel/request-travel")
    // public ResponseEntity<?> requestTravel(@RequestBody RequestTripInput input) {

    //     var body = travelInputMapper.toRequestTripInput(input);
    //     var out = requestTrip.execute(body);
    //     return out.isOk()
    //         ? ResponseEntity.ok(out.unwrap())
    //         : errorHandler.handleDomain(out.unwraprror());
    // }

    // @GetMapping("/travel/request/{id}")
    // public ResponseEntity<?> travelPassenger(@PathVariable UUID id) {
    //     var out = finder.findTravelPassangerById(id); 
    //     return out.isOk() 
    //             ? ResponseEntity.ok(out.unwrap())
    //             : errorHandler.handleDomain(out.unwraprror());
    // }

    // @GetMapping("/travel/request")
    // public ResponseEntity<?> findAllTravelPassenger(
    //     @RequestParam(required = false) UUID travelId,
    //     @RequestParam(defaultValue = "1")
    //         @Min(value = 1, message = "page, o número da página deve ser maior ou igual a 1")
    //         int page,
    //     @RequestParam(defaultValue = "20")
    //         @Positive(message = "size, tamanho da página deve ser maior ou igual a 1")
    //         int size,
    //     @RequestParam(defaultValue = "createdAt")
    //         @Pattern(
    //             regexp = "^(createdAt|updatedAt)$",
    //             message = "orderBy, ordenação por: createdAt ou updatedAt")
    //         String orderBy,
    //     @RequestParam(defaultValue = "desc")
    //       @Pattern(regexp = "^(asc|desc)$", message = "order, ordem: asc ou desc")
    //       String order
    // ) {
    //     var spec = new TravelQueryBuilder().withTravel(travelId).build();
    //     var pageable = Paginator.fromRequest(page, size, order, orderBy);
    //     var out = finder.findAll(spec, pageable);
    //     return ResponseEntity.status(HttpStatus.OK).body(out);
    // }

    // @PatchMapping("/travel/request/approve/{id}")
    // public ResponseEntity<?> approveRequest(@PathVariable UUID id) {
    //     var out = approveRequest.execute(id); 
    //     return out.isOk() 
    //             ? ResponseEntity.ok(out.unwrap())
    //             : errorHandler.handleDomain(out.unwraprror());
    // }
    
    // @PatchMapping("/travel/request/reject/{id}")
    // public ResponseEntity<?> rejectRequest(@PathVariable UUID id) {
    //     var out = rejectRequestTravel.execute(id); 
    //     return out.isOk() 
    //             ? ResponseEntity.ok(out.unwrap())
    //             : errorHandler.handleDomain(out.unwraprror());
    // }

    // @PatchMapping("/travel/finish/{id}")
    // public ResponseEntity<?> finishTravel(@PathVariable UUID id) {
    //     var out = finishTravel.execute(id); 
    //     return out.isOk() 
    //             ? ResponseEntity.ok(out.unwrap())
    //             : errorHandler.handleDomain(out.unwraprror());
    // }

    
}
