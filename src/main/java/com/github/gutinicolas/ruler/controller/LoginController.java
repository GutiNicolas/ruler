package com.github.gutinicolas.ruler.controller;

import com.github.gutinicolas.ruler.model.graphQLUtilsModel.GraphMapEntry;
import com.github.gutinicolas.ruler.model.requests.LoginRequestModel;
import com.github.gutinicolas.ruler.model.responses.LoginResponseModel;
import com.github.gutinicolas.ruler.service.login.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class LoginController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LoginService loginService;


    public LoginResponseModel login(Map<String, Object> request) {
        logger.info("Received login request, request is {}", request);
        loginService.validateLogin(request);
        return new LoginResponseModel(true, "Test", new ArrayList<GraphMapEntry>(), null);
    }
}
