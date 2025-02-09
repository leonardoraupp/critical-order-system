package com.example.messaging.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RpcMessageConsumer {

    // Process the received message and return a response(RPC)
    @RabbitListener(queues = "rpc-queue")
    public String processMessage(String message) {
        return "Server response - message: Received message on queue rpc-queue:" + message;
    }
}
