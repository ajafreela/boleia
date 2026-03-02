package com.boleia.boleia.infra.entity.travel;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelModelJpas extends JpaRepository<TravelEntity, UUID>, JpaSpecificationExecutor<TravelEntity> {
    
}
