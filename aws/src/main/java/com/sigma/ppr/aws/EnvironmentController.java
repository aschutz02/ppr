package com.sigma.ppr.aws;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class EnvironmentController {

    @Value("${APP_ENV:unknown}")
    private String appEnv;

    @GetMapping("/environment")
    public String getEnvironment() {
        return "You are on " + appEnv + " environment";
    }
}
