package com.sms_service.com.Config;

import com.twilio.Twilio;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioConfig {
    private static final String twilio_SID = "AC21157339ec1e3b3ccb81c2eb0b0891b6";
    private static final String twilio_token = "09e3795280ad5f3798dec5b7a8db1297";

    public TwilioConfig() {
        Twilio.init(twilio_SID, twilio_token);
        System.out.println(twilio_SID + "---" + twilio_token);
    }
}
