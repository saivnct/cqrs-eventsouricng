package com.giangbb.microservices.cqrs.cmd.api.commands;

import com.giangbb.microservices.cqrs.cmd.domain.AccountAggregate;
import com.giangbb.microservices.cqrs.core.handlers.EventSourcingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// The 'ConcreteColleague' class
@Service
public class AccountCommandHandler implements CommandHandler {
    @Autowired
    private EventSourcingHandler<AccountAggregate> eventSourcingHandler;

    @Override
    public void handle(OpenAccountCommand command) {
        var aggregate = new AccountAggregate(command);
        eventSourcingHandler.save(aggregate);
    }

    @Override
    public void handle(DepositFundsCommand command) {
        var aggregate = eventSourcingHandler.getById(command.getId());
        aggregate.depositFunds(command.getAmount());
        eventSourcingHandler.save(aggregate);
    }

    @Override
    public void handle(WithdrawFundsCommand command) {
        var aggregate = eventSourcingHandler.getById(command.getId());
        if (command.getAmount() > aggregate.getBalance()) {
            throw new IllegalStateException("Withdrawal declined, insufficient funds!");
        }
        aggregate.withdrawFunds(command.getAmount());
        eventSourcingHandler.save(aggregate);
    }

    @Override
    public void handle(CloseAccountCommand command) {
        var aggregate = eventSourcingHandler.getById(command.getId());
        aggregate.closeAccount();
        eventSourcingHandler.save((aggregate));
    }

    @Override
    public void handle(RestoreReadDbCommand command) {
        eventSourcingHandler.republishEvents();
    }
}
