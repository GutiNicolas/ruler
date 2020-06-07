package com.github.gutinicolas.ruler.service.login;

import com.github.gutinicolas.ruler.model.requests.LoginRequestModel;

import java.util.Map;
import java.util.concurrent.Future;

public interface LoginService {

    public abstract Map<String, Object> validateLogin(Map<String, Object> request);
}
