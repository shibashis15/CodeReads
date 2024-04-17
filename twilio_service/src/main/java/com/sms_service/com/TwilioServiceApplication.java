package com.sms_service.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class TwilioServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(TwilioServiceApplication.class, args);
    }

}
