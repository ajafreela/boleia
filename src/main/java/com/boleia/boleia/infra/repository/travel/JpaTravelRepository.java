package com.boleia.boleia.infra.repository.travel;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.boleia.boleia.infra.entity.travel.TravelEntity;

@Repository
public interface JpaTravelRepository extends JpaRepository<TravelEntity, UUID>, JpaSpecificationExecutor<TravelEntity> {}
