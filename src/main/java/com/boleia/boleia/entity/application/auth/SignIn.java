package com.boleia.boleia.entity.application.auth;

import org.springframework.stereotype.Service;

import com.boleia.boleia.domain.model.Password;
import com.boleia.boleia.entity.domain.DriverRepository;
import com.boleia.boleia.entity.domain.PasswordIsWrongError;
import com.boleia.boleia.entity.domain.SignInOutput;
import com.boleia.boleia.entity.domain.UserRepository;
import com.boleia.boleia.shared.application.GenerateToken;
import com.boleia.boleia.shared.error.DomainError;
import com.boleia.boleia.shared.types.Result;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignIn {
    private final UserRepository userRepository;
    private final DriverRepository driverRepository;
    private GenerateToken generateToken;

    public Result<SignInOutput, DomainError> execute(SignInInput input){
        var userOrErr = this.userRepository.findByPhoneNumber(input.phoneNumber());
        if(userOrErr.isError()) return Result.error(userOrErr.unwrapError());

        var driverOrErr = this.driverRepository.findByUserId(userOrErr.unwrap().getId());
        if(driverOrErr.isError()) return Result.error(driverOrErr.unwrapError());

        var aPassword = new Password();
        var passwordMatched = aPassword.matches(input.password(), driverOrErr.unwrap().getPassword());

        if(!passwordMatched) return Result.error(new PasswordIsWrongError());

        var tokenResponse = this.generateToken.generateToken(userOrErr.unwrap());

        var out = new SignInOutput(tokenResponse.unwrap());

        return Result.ok(out);
    }
}
