package com.sms_service.com.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class  twilio_integration_service {
    private static final String fromPhoneNumber = System.getenv("twilio_phoneNumber");

    public String sendSMS(String userPhoneNumber, String messageBody) {
        try {
            Message message = Message.creator
                            (new PhoneNumber(fromPhoneNumber), new PhoneNumber(userPhoneNumber), messageBody)
                    .create();
            return message.getSid();
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
