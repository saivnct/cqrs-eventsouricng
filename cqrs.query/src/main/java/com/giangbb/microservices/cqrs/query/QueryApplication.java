package com.giangbb.microservices.cqrs.query;

import com.giangbb.microservices.cqrs.core.infrastructure.QueryDispatcher;
import com.giangbb.microservices.cqrs.query.api.queries.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QueryApplication {

	@Autowired
	private QueryDispatcher queryDispatcher;

	@Autowired
	private QueryHandler queryHandler;

	public static void main(String[] args) {
		SpringApplication.run(QueryApplication.class, args);
	}

	@PostConstruct
	public void registerHandlers() {
		queryDispatcher.registerHandler(FindAllAccountsQuery.class, queryHandler::handle);
		queryDispatcher.registerHandler(FindAccountByIdQuery.class, queryHandler::handle);
		queryDispatcher.registerHandler(FindAccountByHolderQuery.class, queryHandler::handle);
		queryDispatcher.registerHandler(FindAccountWithBalanceQuery.class, queryHandler::handle);
	}
}
