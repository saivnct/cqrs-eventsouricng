package com.giangbb.microservices.cqrs.query.api.queries;

import com.giangbb.microservices.cqrs.query.api.dto.EqualityType;
import com.giangbb.microservices.cqrs.core.queries.BaseQuery;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindAccountWithBalanceQuery extends BaseQuery {
    private EqualityType equalityType;
    private double balance;
}
