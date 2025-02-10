package com.example.messaging.service.notification;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SmsConsumer {

    @RabbitListener(queues = "sms-queue")
    public void receiveSmslNotification(String message) {
        System.out.println("[SMS] Sending SMS: " + message);
    }
}
