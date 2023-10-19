package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerHello {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("HelloWorld","Hello World");
        return "hello";
    }
}
