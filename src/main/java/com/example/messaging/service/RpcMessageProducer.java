package com.example.messaging.service;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class RpcMessageProducer {
    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange exchange;

    public RpcMessageProducer(RabbitTemplate rabbitTemplate, DirectExchange exchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
    }

    public String sendRpcMessage(String message) {
        return (String) rabbitTemplate.convertSendAndReceive(exchange.getName(), "rpc", message);
    }

}
