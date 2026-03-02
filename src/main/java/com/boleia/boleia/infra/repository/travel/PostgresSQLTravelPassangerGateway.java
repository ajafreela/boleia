package com.boleia.boleia.infra.repository.travel;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import com.boleia.boleia.infra.entity.User.UserEntity;
import com.boleia.boleia.infra.entity.travel.TravelEntity;
import com.boleia.boleia.infra.entity.travel.TravelPassangerModel;
import com.boleia.boleia.infra.entity.travel.TravelPassangerModelJpa;
import com.boleia.boleia.infra.entity.travel.TravelPassangerResponse;
import com.boleia.boleia.infra.repository.User.schema.UserResponse;
import com.boleia.boleia.infra.repository.travel.schema.TravelResponse;
import com.boleia.boleia.infra.shared.types.Pagination;
import com.boleia.boleia.infra.shared.types.Paginator;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PostgresSQLTravelPassangerGateway implements TravelPassangerGateway {

    final TravelPassangerModelJpa jpa;

    @Override
    public Pagination<TravelPassangerResponse> findAll(Specification<TravelPassangerModel> spec, Pageable pageable) {
        
        
        Page<TravelPassangerModel> page = this.jpa.findAll(spec, pageable);
        
        List<TravelPassangerResponse> list = page.getContent().stream().map(this::toTravelPassangerResponse).toList();
        
        return Paginator.<TravelPassangerResponse>toPagination(list, page, page.getSize());

    }

    private TravelPassangerResponse toTravelPassangerResponse(TravelPassangerModel model){
        return new TravelPassangerResponse(
            model.getId(),
            model.getStatus(),
            toUserResponse(model.getPassangerId()),
            toTravelResponse(model.getTravelId()),
            model.getUpdatedAt(),
            model.getCreatedAt()
        );
    }

    private UserResponse toUserResponse(UserEntity model) {
        return new UserResponse(
            model.getId(),
            model.getFirstName(),
            model.getLastName(),
            model.getPhoneNumber(),
            model.getType(),
            model.getStatus(),
            model.getCreatedAt(),
            model.getUpdatedAt(),
            null);
    }

    private TravelResponse toTravelResponse(TravelEntity model) {
        return new TravelResponse(
            model.getId(),
            null,
            model.getStartTime(),
            model.getStatus(),
            null,
            model.getPrice(),
            model.getDestiny(),
            model.getStops()
        );
    }
}
