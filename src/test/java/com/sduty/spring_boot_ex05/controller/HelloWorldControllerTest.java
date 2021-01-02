package com.sduty.spring_boot_ex05.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloWorldControllerTest {

    @Autowired
    private HelloWorldController helloWorldController;

    @Test
    void helloWorld() {
        System.out.println(helloWorldController.helloWorld());

//        Assertions.assertThat()
    }
}