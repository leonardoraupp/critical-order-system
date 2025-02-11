# Critical Order System project
A critical order management system with advanced failure handling and notifications, leveraging RabbitMQ for asynchronous and resilient communication.

## About the project
The Critical Order System (COS) is a robust backend system for order management and critical notifications. It utilizes RabbitMQ to process orders asynchronously, ensuring scalability and reliability.

The system implements a Dead Letter Queue (DLQ) mechanism to handle failures, along with Retry and Time-To-Live (TTL) strategies to prevent message loss. Additionally, it features Priority Queues to ensure that urgent orders are processed first.

The main workflow includes:

- Order creation via API.
- Asynchronous processing of orders through RabbitMQ.
- Critical notifications (SMS, Email, Push) based on order status.
- Failure recovery mechanism using DLQ.
- Intelligent retry handling to prevent order loss.

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
