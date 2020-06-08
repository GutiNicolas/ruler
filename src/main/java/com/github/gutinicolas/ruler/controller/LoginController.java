package com.github.gutinicolas.ruler.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.gutinicolas.ruler.model.graphQLUtilsModel.GraphMapEntry;
import com.github.gutinicolas.ruler.model.requests.LoginRequestModel;
import com.github.gutinicolas.ruler.model.responses.LoginResponseModel;
import com.github.gutinicolas.ruler.service.login.LoginService;
import com.github.gutinicolas.ruler.utils.GraphQLUtils;
import com.github.gutinicolas.ruler.utils.PathUtils;
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

    @Autowired
    GraphQLUtils graphQLUtils;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    PathUtils pathUtils;


    public LoginResponseModel login(Map<String, Object> request) throws JsonProcessingException {
        logger.info("Received login request, request is {}", request);
        loginService.validateLogin(request);
        Map<String, Object> map = objectMapper.readValue(pathUtils.path(request, "data.value").toStr().orElse(""), Map.class);
        request.put("data", map);
        return new LoginResponseModel(true, "Test", request, null);
    }
}
