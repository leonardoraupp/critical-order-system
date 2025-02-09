package com.example.messaging.controller;

import com.example.messaging.service.RpcMessageProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rpc")
public class RpcController {

    private final RpcMessageProducer producer;

    public RpcController(RpcMessageProducer producer) {
        this.producer = producer;
    }

    @PostMapping()
    public ResponseEntity<String> send(@RequestBody String message) {
        message = producer.sendRpcMessage(message);
        return ResponseEntity.ok().body(message);
    }
}
