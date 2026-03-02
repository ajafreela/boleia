package com.boleia.boleia.infra.controller.Notification;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boleia.boleia.application.Notification.OtpService;
import com.boleia.boleia.application.Notification.ValidationOtpService;
import com.boleia.boleia.domain.model.Notification.dto.OtpInputDto;
import com.boleia.boleia.domain.model.Notification.dto.ValidationOtpDto;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


// @RestController
// @RequestMapping("/boleia/api/v1")
// @Tag(name = "Notification", description = "Notification management")
public class OtpController {
    
    // private final OtpService otpService;
    // private final ValidationOtpService validationOtpService;

    // public OtpController(
    //     OtpService otpService,
    //     ValidationOtpService validationOtpService
    // ){
    //     this.otpService = otpService;
    //     this.validationOtpService = validationOtpService;
    // }

    // @PostMapping("validate-otp")
    // public String send(@RequestBody ValidationOtpDto inputDto) {
        
    //     this.validationOtpService.execute(inputDto);

    //     String message = "Otp validated";
    //     return message;
    // }

    // @PostMapping("generate-otp")
    // public String generate(@RequestBody OtpInputDto inputDto) {
        
    //     this.otpService.sendOtp(inputDto.phoneNumber());
        
    //     String message = "Otp Generated";
    //     return message;
    // }
    

}
