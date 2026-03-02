// package com.boleia.boleia.infra.repository.travel;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.UUID;
// import java.util.stream.Collectors;

// import org.springframework.stereotype.Repository;

// import com.boleia.boleia.domain.model.User.User;
// import com.boleia.boleia.domain.model.Vehicle.Vehicle;
// import com.boleia.boleia.domain.model.travel.Travel;
// import com.boleia.boleia.infra.entity.User.UserEntity;
// import com.boleia.boleia.infra.entity.Vehicle.VehicleEntity;
// import com.boleia.boleia.infra.entity.travel.TravelEntity;
// import com.boleia.boleia.infra.repository.User.UserRepository;
// import com.boleia.boleia.infra.repository.Vehicle.VehicleRepository;
// import com.boleia.boleia.infra.repository.travel.schema.TravelResponse;
// import com.boleia.boleia.infra.shared.Exception.CustomNotFoundException;
// import com.boleia.boleia.infra.shared.types.Result;

// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;

// @Repository
// @RequiredArgsConstructor
// @Slf4j
// public class TravelRepository implements TravelProtocol {

//     final JpaTravelRepository jpa;
//     final VehicleRepository vehicleRepository;
//     final UserRepository userRepository;
    

//     public Travel toDomain(TravelEntity e){
        
//         Vehicle vehicle = vehicleRepository.toDomain(e.getVehicle());

//         List<User> passengers = e.getPassenger() == null ? new ArrayList<>() :
//             e.getPassenger() 
//             .stream()
//             .map(userRepository::toDomain)
//             .collect(Collectors.toList());

//         return new Travel(
//             e.getId(),
//             vehicle,
//             e.getStartTime(),
//             e.getStatus(),
//             passengers,
//             e.getPrice(),
//             e.getDestiny(),
//             new ArrayList<>(e.getStops())
//         );
//     }

//     private TravelEntity toEntity(Travel e) {

//         VehicleEntity vehicleEntity = vehicleRepository.toEntity(
//             e.getVehicle(), 
//             null
//             // e.getDriver()
//         );

//         List<UserEntity> passengerEntities = e.getPassenger() == null ?
//             new ArrayList<>()
//             : e.getPassenger()
//             .stream()
//             .map(userRepository::toEntity)
//             .collect(Collectors.toList());

//         return new TravelEntity(
//             e.getId(),
//             vehicleEntity,
//             e.getStartTime(),
//             e.getStatus(),
//             passengerEntities,
//             e.getPrice(),
//             e.getDestiny(),
//             // e.getStops()
//             e.getStops() == null ? new ArrayList<>() : new ArrayList<>(e.getStops())
//         );

//     }

//     public UUID save(Travel req) {

//         var entity = this.toEntity(req);
//         this.jpa.save(entity);

//         return entity.getId();

//     }

//     public List<TravelResponse> findAll(){

//         var res = this.jpa.findAll()
//             .stream()
//             .map(e -> 
//                 new TravelResponse(
//                     e.getId(),
//                     vehicleRepository.toDomain(e.getVehicle()),
//                     e.getStartTime(),
//                     e.getStatus(),
//                     e.getPassenger()
//                         .stream()
//                         .map(userRepository::toDomain)
//                         .collect(Collectors.toList()),
//                     e.getPrice(),
//                     e.getDestiny(),
//                     e.getStops() == null ? new ArrayList<>() : new ArrayList<>(e.getStops())
//                 )
//             ).toList();

//         return res;

//     }

//     @Override
//     public Result<Travel, CustomNotFoundException> findByIdTravel(UUID id) {
//         var model = this.jpa.findById(id).get();
//         // log.info("O errrrrrrr0 {}", model.getId().toString());
//         return Result.ok(toTravelResponse(model));
//     }

//     private Travel toTravelResponse(TravelEntity model) {
//         return new Travel(
//             model.getId(),
//             null,
//             model.getStartTime(),
//             model.getStatus(),
//             null,
//             null,
//             model.getDestiny(),
//             null);
//     }

    

//     public TravelEntity findById(UUID id) {
//         var model = this.jpa.findById(id).get();
//         return model;
//     }

// }
