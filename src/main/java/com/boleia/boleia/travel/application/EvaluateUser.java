package com.boleia.boleia.travel.application;

import org.springframework.stereotype.Service;

import com.boleia.boleia.shared.error.DomainError;
import com.boleia.boleia.shared.types.Result;
import com.boleia.boleia.travel.domain.Rating;
import com.boleia.boleia.travel.domain.RatingRepository;
import com.boleia.boleia.travel.domain.user.UserACL;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EvaluateUser {
    private final RatingRepository repository;
    private final UserACL userACL;

    public Result<Void, DomainError> execute(EvaluateUserInput input){
        var userOrErr = this.userACL.findById(input.userId());
        if(userOrErr.isError()) return Result.error(userOrErr.unwrapError());

        var rating = Rating.create(input.userId(), input.ratingValue(), userOrErr.unwrap().getType());

        var voidOrErr = this.repository.save(rating);
        if(voidOrErr.isError()) return Result.error(voidOrErr.unwrapError());

        return Result.ok(null);
    }

}
