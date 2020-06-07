package com.github.gutinicolas.ruler.service.login;

import com.github.gutinicolas.ruler.exceptions.DocumentNotFoundException;
import com.github.gutinicolas.ruler.model.requests.LoginRequestModel;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LoginServiceImpl implements LoginService {


    @Override
    @HystrixCommand(fallbackMethod = "fallback", ignoreExceptions = {DocumentNotFoundException.class},
            threadPoolProperties = {
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "7000"),
                @HystrixProperty(name = "execution.isolation.thread.interruptOnTimeout", value = "true"),
                @HystrixProperty(name = "maximumSize", value = "2"),
            }
    )
    public Map<String, Object> validateLogin(LoginRequestModel request) {
        return Map.of("ok", true, "message", "OK");
    }

    public Map<String, Object> fallback(Map<String, Object> request) {
        return Map.of("ok", false, "message", "Sorry, an error popup on our end!", "request", request);
    }
}
