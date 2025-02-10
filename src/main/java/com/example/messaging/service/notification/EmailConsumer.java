package com.example.messaging.service.notification;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener(queues = "email-queue")
    public void receiveEmailNotification(String message) {
        System.out.println("[EMAIL] Sending e-mail: " + message);
    }
}
