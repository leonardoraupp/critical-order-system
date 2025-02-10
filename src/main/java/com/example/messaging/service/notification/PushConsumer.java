package com.example.messaging.service.notification;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PushConsumer {

    @RabbitListener(queues = "push-queue")
    public void receivePushNotification(String message) {
        System.out.println("[PUSH] Sending push notification: " + message);
    }
}
