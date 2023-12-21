package com.example.demo;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ZutatenController {

    @Autowired
    ZutatenService service;

    Logger logger = LoggerFactory.getLogger(ZutatenController.class);

    @CrossOrigin
    @PostMapping("/zutaten")
    public Zutaten createZutat(@RequestBody Zutaten zutaten){
        return service.save(zutaten);
    }

    @CrossOrigin
    @GetMapping("/zutaten")
    public List<Zutaten> getAllZutaten(){
        return service.getAll();
    }

    @CrossOrigin
    @GetMapping("/zutaten/{id}")
    public Zutaten getZutaten(@PathVariable String id) {
        logger.info("GET request on route zutaten with {}", id);
        Long zutatId = Long.parseLong(id);
        return service.get(zutatId);
    }


}