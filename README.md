![Documentation Status](https://img.shields.io/badge/docs-in%20progress-yellow)
# Demo projeto for RabbitMQ 

## About the project
It utilizes RabbitMQ to process orders asynchronously, ensuring scalability and reliability.

## Run project

### Docker

- Run RabbitMQ container

```sh
docker-compose up -d
```

- Stop RabbitMQ container
  Keep it running if you wish run the application and test.

```sh
docker-compose down
```

### Running application

Run the com.example.messaging.MessagingApplication.class

## Testing

### Endpoint Messages

```sh
curl -d '{"message":"Hello, RabbitMQ!"}' -H "Content-Type: application/json" -X POST http://localhost:8080/messages
```

### Endpoint RPC

This endpoint send back a response from the RabbitMQ queue(from the consumer). It follows the pattern Remote Procedure
Call(RPC).

```sh
curl -d '{"message":"Hello, RabbitMQ!"}' -H "Content-Type: application/json" -X POST http://localhost:8080/rpc
```

### Endpoint Notifications

Endpoint that send a notification to the asynchronous system notification.

```sh
curl -d '{"message":"Hello, RabbitMQ!"}' -H "Content-Type: application/json" -X POST http://localhost:8080/rpc
```
