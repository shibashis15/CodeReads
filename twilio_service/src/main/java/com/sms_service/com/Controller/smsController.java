package com.sms_service.com.Controller;

import com.sms_service.com.Service.twilio_integration_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/twilio")
public class smsController {
    @Autowired
    private twilio_integration_service twilio_integration_service;

    public smsController(twilio_integration_service twilio_integration_service) {
        this.twilio_integration_service = twilio_integration_service;
    }

    @GetMapping("/getStatus")
    public ResponseEntity getStatus() {
        String SID = twilio_integration_service.sendSMS("+916291447461", "FUCK");
        return new ResponseEntity(SID, HttpStatus.OK);
    }

    @PostMapping("/sendSMS")
    public ResponseEntity sendSMS(@RequestBody String phoneNumber, @RequestBody String message) {
        String response = twilio_integration_service.sendSMS(phoneNumber, message);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
