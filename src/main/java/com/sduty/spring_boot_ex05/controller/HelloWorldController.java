package com.sduty.spring_boot_ex05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(value = "/api/helloWolrd")
    public String helloWorld() {
        return "Helloworld";
    }
}
