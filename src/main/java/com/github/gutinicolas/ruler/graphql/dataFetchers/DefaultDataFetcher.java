package com.github.gutinicolas.ruler.graphql.dataFetchers;

import com.github.gutinicolas.ruler.controller.LoginController;
import graphql.schema.DataFetcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginDataFetcher {

    Logger logger = LoggerFactory.getLogger(LoginDataFetcher.class);

    @Autowired
    LoginController loginController;

    public DataFetcher login() {
        logger.info("Adding Login to GraphQL Resolvers");
        return dataFetchingEnvironment -> loginController.login(dataFetchingEnvironment.getArgument("request"));
    }
}
