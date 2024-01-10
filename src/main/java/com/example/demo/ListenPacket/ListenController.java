package com.example.demo.ListenPacket;

import com.example.demo.ZutatenPacket.ZutatenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListenController {

    @Autowired
    ListenService service;
    ZutatenService zutatenService;


    Logger logger = LoggerFactory.getLogger(ListenController.class);
    @CrossOrigin
    @PostMapping("/listen")
    public Listen createListe(@RequestBody Listen listen){
        return service.save(listen);
    }

    @CrossOrigin
    @GetMapping("/listen")
    public List<Listen> getAllListen(@RequestParam("owner") String owner){
        return owner.isEmpty() ? service.getAllWithoutOwner() : service.getAllOwnedBy(owner);
    }

    @CrossOrigin
    @GetMapping("/listen/{id}")
    public Listen getListen(@PathVariable String id) {
        logger.info("GET request on route listen with {}", id);
        Long listeId = Long.parseLong(id);
        return service.get(listeId);
    }

    @CrossOrigin
    @DeleteMapping("/listen/{id}")
    public void deleteListe(@PathVariable Long id){
        service.delete(id);
    }

}
