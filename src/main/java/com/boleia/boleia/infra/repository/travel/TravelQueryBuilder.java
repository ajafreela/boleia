package com.boleia.boleia.infra.repository.travel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.domain.Specification;

import com.boleia.boleia.infra.entity.travel.TravelPassangerModel;

import jakarta.persistence.criteria.Predicate;

public class TravelQueryBuilder {

    private UUID travelId;

  public TravelQueryBuilder withTravel(UUID value) {
    this.travelId = value;
    return this;
  }

  public Specification<TravelPassangerModel> build() {
    return (root, __, criteriaBuilder) -> {
      List<Predicate> predicates = new ArrayList<>();

      if (this.travelId != null) {
        predicates.add(
            criteriaBuilder.equal(root.get("travelId").get("id"), this.travelId));
      }

      return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    };
  }

}