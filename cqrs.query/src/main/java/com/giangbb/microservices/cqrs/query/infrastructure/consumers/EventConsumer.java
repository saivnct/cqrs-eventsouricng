package com.giangbb.microservices.cqrs.query.infrastructure.consumers;

import com.giangbb.microservices.cqrs.common.events.AccountClosedEvent;
import com.giangbb.microservices.cqrs.common.events.AccountOpenedEvent;
import com.giangbb.microservices.cqrs.common.events.FundsDepositedEvent;
import com.giangbb.microservices.cqrs.common.events.FundsWithdrawnEvent;
import com.giangbb.microservices.cqrs.core.events.BaseEvent;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

public interface EventConsumer {
    void consume(@Payload BaseEvent event, Acknowledgment ack);
    void consumeRepublicEvent(@Payload BaseEvent event, Acknowledgment ack);
}
