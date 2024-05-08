package com.giangbb.microservices.cqrs.cmd.api.commands;

import com.giangbb.microservices.cqrs.common.dto.AccountType;
import com.giangbb.microservices.cqrs.core.commands.BaseCommand;
import lombok.Data;

@Data
public class OpenAccountCommand extends BaseCommand {
    private String accountHolder;
    private AccountType accountType;
    private double openingBalance;
}