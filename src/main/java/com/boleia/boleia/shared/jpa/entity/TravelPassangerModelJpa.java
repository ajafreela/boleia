package com.boleia.boleia.shared.jpa.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TravelPassangerModelJpa extends JpaRepository<TravelPassangerModel, String>, JpaSpecificationExecutor<TravelPassangerModel> {
    Optional<TravelPassangerModel> findByPassengerId(String id);
}
