package com.github.gutinicolas.ruler.graphql.dataFetchers;

import com.github.gutinicolas.ruler.controller.LoginController;
import com.github.gutinicolas.ruler.model.requests.LoginRequestModel;
import graphql.schema.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginDataFetcher {

    @Autowired
    LoginController loginController;

    public DataFetcher login(LoginRequestModel request) {
        return dataFetchingEnvironment -> loginController.login(request);
    }
}
