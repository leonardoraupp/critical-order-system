package com.example.messaging.controller;

import com.example.messaging.service.notification.NotificationProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationProducer producer;

    public NotificationController(NotificationProducer producer) {
        this.producer = producer;
    }

    @PostMapping()
    public ResponseEntity<String> send(@RequestBody String notification) {
        producer.sendNotification(notification);
        return ResponseEntity.ok("Notification sent: " + notification);
    }
}
