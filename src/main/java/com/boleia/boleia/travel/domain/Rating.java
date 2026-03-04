package com.boleia.boleia.travel.domain;

import java.util.UUID;

import lombok.Getter;

@Getter
public class Rating {
    private UUID id;
    private UUID userId;
    private Integer rating;
    private boolean isDriver;

    private Rating(
        UUID id,
        UUID userId,
        Integer rating,
        boolean isDriver
    ){
        this.id = id;
        this.userId = userId;
        this.rating = rating;
        this.isDriver = isDriver;
    }

    public static Rating create(
        UUID userId,
        Integer rating,
        boolean isDriver
    ){
        return new Rating(UUID.randomUUID(), userId, rating, isDriver);
    }

    public static Rating from(
        UUID id,
        UUID userId,
        Integer rating,
        boolean isDriver
    ){
        return new Rating(id, userId, rating, isDriver);
    }

}
