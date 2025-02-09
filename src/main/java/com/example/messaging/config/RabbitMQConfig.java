package com.example.messaging.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue myQueue() {
        return new Queue("my-queue", true);
    }

    @Bean
    public Queue rpcQueue() {
        return new Queue("rpc-queue", true);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("rpc-exchange");
    }

    @Bean
    public Binding binding(Queue rpcQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(rpcQueue).to(directExchange).with("rpc");
    }
}
