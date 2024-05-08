package com.giangbb.microservices.cqrs.query.infrastructure.consumers;

import com.giangbb.microservices.cqrs.common.events.AccountClosedEvent;
import com.giangbb.microservices.cqrs.common.events.AccountOpenedEvent;
import com.giangbb.microservices.cqrs.common.events.FundsDepositedEvent;
import com.giangbb.microservices.cqrs.common.events.FundsWithdrawnEvent;
import com.giangbb.microservices.cqrs.core.events.BaseEvent;
import com.giangbb.microservices.cqrs.query.infrastructure.handlers.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class AccountEventConsumer implements EventConsumer {
    @Autowired
    private EventHandler eventHandler;

    @KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(@Payload BaseEvent event, Acknowledgment ack) {
        try {
            var eventHandlerMethod = eventHandler.getClass().getDeclaredMethod("on", event.getClass());
            eventHandlerMethod.setAccessible(true);
            eventHandlerMethod.invoke(eventHandler, event);
            ack.acknowledge();
        } catch (Exception e) {
            throw new RuntimeException("Error while consuming event", e);
        }
    }

    @KafkaListener(topics = "${spring.kafka.topic-republic}", groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consumeRepublicEvent(@Payload BaseEvent event, Acknowledgment ack) {
        try {
            var eventHandlerMethod = eventHandler.getClass().getDeclaredMethod("on", event.getClass());
            eventHandlerMethod.setAccessible(true);
            eventHandlerMethod.invoke(eventHandler, event);
            ack.acknowledge();
        } catch (Exception e) {
            throw new RuntimeException("Error while consuming event", e);
        }
    }
}
