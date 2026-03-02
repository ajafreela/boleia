package com.boleia.boleia.infra.entity.travel;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.boleia.boleia.domain.model.travel.TravelPassanger;

@Repository
public interface TravelPassangerModelJpa  extends JpaRepository<TravelPassangerModel, UUID>, JpaSpecificationExecutor<TravelPassangerModel>{
    List<TravelPassanger> findByTravelId_id(UUID id);
}
