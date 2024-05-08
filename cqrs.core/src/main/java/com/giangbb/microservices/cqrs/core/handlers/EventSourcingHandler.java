package com.giangbb.microservices.cqrs.core.handlers;

import com.giangbb.microservices.cqrs.core.domain.AggregateRoot;


//The event sourcing handler provides an interface abstraction through which the command handler can obtain the latest state of the aggregate
// and through which it can persist the uncommitted changes on the aggregate as events to the event store.

public interface EventSourcingHandler<T> {
    void save(AggregateRoot aggregate); //all aggregate are extends from AggregateRoot
    T getById(String id);       //return the latest state of the aggregate
    void republishEvents();
}
