package com.github.gutinicolas.ruler.graphql.dataFetchers;

import graphql.schema.DataFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DefaultDataFetcher {

    Logger logger = LoggerFactory.getLogger(DefaultDataFetcher.class);

    public DataFetcher isAlive() {
        logger.info("Adding isAlive to GraphQL Resolvers");
        return dataFetchingEnvironment -> isServerAlive();
    }

    private String isServerAlive() {
        return "Server alive";
    }
}
