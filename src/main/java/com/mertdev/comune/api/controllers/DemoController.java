package com.mertdev.comune.api.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SecurityRequirement(name = "Bearer Authentication")
@RestController
@RequestMapping("api/v1/demo")
public class DemoController {
    @GetMapping
    public String getDemo(){
        return "Hello World";
    }
}
