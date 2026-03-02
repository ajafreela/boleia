package com.boleia.boleia.travel.domain.user;

import java.util.UUID;

import lombok.Getter;

@Getter
public class User {
    private UUID id;

    public User(
        UUID id
    ) {
        this.id = id;
    }
}
