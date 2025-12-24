package com.example.demo.service;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class OTPService {

    @Autowired
    private JavaMailSender gmailSender;

    private final String ADMIN_GMAIL = "2200030108cseh@gmail.com";

    private String lastOtp;
    private Instant otpTime;

    public void sendOtpToUser(String userEmail) {
        String otp = String.format("%05d", new Random().nextInt(100000));
        lastOtp = otp;
        otpTime = Instant.now();

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(ADMIN_GMAIL);
        msg.setTo(userEmail);
        msg.setSubject("OTP Verification");
        msg.setText("Your OTP is: " + otp + "\nValid for 5 minutes.");

        gmailSender.send(msg);
    }

    public boolean verifyOtp(String otp) {
        if (lastOtp == null || otpTime == null) return false;
        if (!lastOtp.equals(otp)) return false;
        return Duration.between(otpTime, Instant.now()).toMinutes() <= 5;
    }
}
