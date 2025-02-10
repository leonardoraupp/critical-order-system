package com.example.messaging.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("rpc-exchange");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("notification-exchange");
    }

    @Bean
    public Queue myQueue() {
        return new Queue("my-queue", true);
    }

    @Bean
    public Queue rpcQueue() {
        return new Queue("rpc-queue", true);
    }

    @Bean
    public Queue emailQueue() {
        return new Queue("email-queue", true);
    }

    @Bean
    public Queue smsQueue() {
        return new Queue("sms-queue", true);
    }

    @Bean
    public Queue pushQueue() {
        return new Queue("push-queue", true);
    }

    @Bean
    public Binding binding(Queue rpcQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(rpcQueue).to(directExchange).with("rpc");
    }

    @Bean
    public Binding bindingEmailQueue(Queue emailQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(emailQueue).to(fanoutExchange);
    }

    @Bean
    public Binding bindingSmsQueue(Queue smsQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(smsQueue).to(fanoutExchange);
    }

    @Bean
    public Binding bindingPushQueue(Queue pushQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(pushQueue).to(fanoutExchange);
    }
}
