package com.example.demo;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ZutatenController {

    @Autowired
    ZutatenService service;

    Logger logger = LoggerFactory.getLogger(ZutatenController.class);

    @PostMapping("/zutaten")
    public Zutaten createZutat(@RequestBody Zutaten zutaten){
        return service.save(zutaten);
    }

    @GetMapping("/zutaten")
    public List<Zutaten> getAllZutaten(){
        return service.getAll();
    }

}