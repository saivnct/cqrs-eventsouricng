package com.giangbb.microservices.cqrs.core.infrastructure;

import com.giangbb.microservices.cqrs.core.commands.BaseCommand;
import com.giangbb.microservices.cqrs.core.commands.CommandHandlerMethod;

public interface CommandDispatcher {
    <T extends BaseCommand> void registerHandler(Class<T> type, CommandHandlerMethod<T> handler);
    void send(BaseCommand command);
}
