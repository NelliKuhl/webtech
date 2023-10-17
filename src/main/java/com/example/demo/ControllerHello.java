package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHello {

    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

}
