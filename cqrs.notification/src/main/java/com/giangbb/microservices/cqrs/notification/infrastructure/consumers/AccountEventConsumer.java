package com.giangbb.microservices.cqrs.notification.infrastructure.consumers;

import com.giangbb.microservices.cqrs.common.events.FundsDepositedEvent;
import com.giangbb.microservices.cqrs.common.events.FundsWithdrawnEvent;
import com.giangbb.microservices.cqrs.core.events.BaseEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AccountEventConsumer implements EventConsumer {
    private final Logger logger = Logger.getLogger(AccountEventConsumer.class.getName());

    @KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    @Override
    public void consume(@Payload BaseEvent event, Acknowledgment ack) {
        try {
            if (event instanceof FundsDepositedEvent){
                FundsDepositedEvent depositedEvent = (FundsDepositedEvent) event;
                logger.log(Level.INFO, "Received Deposit for " + depositedEvent.getId() + " : " + depositedEvent.getAmount());
            }else if (event instanceof FundsWithdrawnEvent){
                FundsWithdrawnEvent withdrawnEvent = (FundsWithdrawnEvent) event;
                logger.log(Level.INFO, "Received Withdrawal for " + withdrawnEvent.getId() + " : " + withdrawnEvent.getAmount());
            }
            ack.acknowledge();
        } catch (Exception e) {
            throw new RuntimeException("Error while consuming event", e);
        }
    }
}
