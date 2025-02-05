package com.jwtapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/api/public")
    public String publicEndpoint() {
        return "This is a public endpoint";
    }

    @GetMapping("/api/private")
    public String privateEndpoint() {
        return "This is a private endpoint";
    }
}
