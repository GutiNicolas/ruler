package com.github.gutinicolas.ruler.controller;

import com.github.gutinicolas.ruler.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;


    public Map<String, Object> login(Map<String, Object> request) {
        return loginService.validateLogin(request);
    }
}
