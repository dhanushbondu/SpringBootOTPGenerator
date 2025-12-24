# SpringBootOTPGenerator
using the springboot generating the 5digit otp

⚙️ Gmail Setup (Required)
Step 1: Enable 2-Step Verification

Go to 👉 https://myaccount.google.com/security

Enable 2-Step Verification

Step 2: Generate App Password

Open 👉 https://myaccount.google.com/apppasswords

Enter an App name (example: SpringBootOTP)

Click Create

Copy the 16-character password shown in the popup

⚠️ The password is shown only once

Step 3: Configure application.properties

Paste the generated app password:
```
spring.application.name=OTP

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=yourgmail@gmail.com
spring.mail.password=xxxx xxxx xxxx xxxx
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.default-encoding=UTF-8
```
🚀 Features

Generates a 5-digit OTP

Sends OTP via email

OTP valid for 5 minutes

Simple REST APIs
