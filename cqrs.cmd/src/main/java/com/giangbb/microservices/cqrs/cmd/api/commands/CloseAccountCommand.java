package com.giangbb.microservices.cqrs.cmd.api.commands;

import com.giangbb.microservices.cqrs.core.commands.BaseCommand;

public class CloseAccountCommand extends BaseCommand {
    public CloseAccountCommand(String id) {
        super(id);
    }
}
