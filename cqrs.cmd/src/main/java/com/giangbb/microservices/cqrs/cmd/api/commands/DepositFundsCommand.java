package com.giangbb.microservices.cqrs.cmd.api.commands;

import com.giangbb.microservices.cqrs.core.commands.BaseCommand;
import lombok.Data;

@Data
public class DepositFundsCommand extends BaseCommand {
    private double amount;
}
