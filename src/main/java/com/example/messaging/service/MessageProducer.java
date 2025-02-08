package com.example.messaging.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

// Send message to the RabbitMQ
@Service
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.template.default-receive-queue}")
    private String queueName;

    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(queueName, message);
    }
}
