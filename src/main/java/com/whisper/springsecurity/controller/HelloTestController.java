package com.whisper.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloTestController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
