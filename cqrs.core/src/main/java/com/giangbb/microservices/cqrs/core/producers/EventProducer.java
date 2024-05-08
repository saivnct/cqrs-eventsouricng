package com.giangbb.microservices.cqrs.core.producers;

import com.giangbb.microservices.cqrs.core.events.BaseEvent;

public interface EventProducer {
    void produce(String topic, BaseEvent event);
}
