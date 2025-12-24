package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.OTPService;

import java.util.Map;

@RestController
@RequestMapping("/otp")
@CrossOrigin
public class OTPController {

    @Autowired
    private OTPService otpService;

    @PostMapping("/send")
    public String sendOtp(@RequestBody Map<String, String> body) {
        otpService.sendOtpToUser(body.get("email"));
        return "OTP sent successfully";
    }

    @PostMapping("/verify")
    public String verifyOtp(@RequestBody Map<String, String> body) {
        return otpService.verifyOtp(body.get("otp"))
                ? "OTP verified"
                : "Invalid or expired OTP";
    }
}
