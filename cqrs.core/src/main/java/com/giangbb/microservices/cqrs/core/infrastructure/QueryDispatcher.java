package com.giangbb.microservices.cqrs.core.infrastructure;

import com.giangbb.microservices.cqrs.core.domain.BaseEntity;
import com.giangbb.microservices.cqrs.core.queries.BaseQuery;
import com.giangbb.microservices.cqrs.core.queries.QueryHandlerMethod;

import java.util.List;

public interface QueryDispatcher {
    <T extends BaseQuery> void registerHandler(Class<T> type, QueryHandlerMethod<T> handler);
    <U extends BaseEntity> List<U> send(BaseQuery query);
}
