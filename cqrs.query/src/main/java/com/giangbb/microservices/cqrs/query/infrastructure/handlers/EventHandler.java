package com.giangbb.microservices.cqrs.query.infrastructure.handlers;

import com.giangbb.microservices.cqrs.common.events.AccountClosedEvent;
import com.giangbb.microservices.cqrs.common.events.AccountOpenedEvent;
import com.giangbb.microservices.cqrs.common.events.FundsDepositedEvent;
import com.giangbb.microservices.cqrs.common.events.FundsWithdrawnEvent;

public interface EventHandler {
    void on(AccountOpenedEvent event);
    void on(FundsDepositedEvent event);
    void on(FundsWithdrawnEvent event);
    void on(AccountClosedEvent event);
}
