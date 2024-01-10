package com.example.demo.ZutatenPacket;

import com.example.demo.ListenPacket.Listen;
import com.example.demo.ListenPacket.ListenService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
public class ZutatenController {

    @Autowired
    ZutatenService zutatenService;

    @Autowired
    ListenService listenService;

    Logger logger = LoggerFactory.getLogger(ZutatenController.class);

    @CrossOrigin
    @PostMapping("/listen/{id}/zutaten")
    public Zutaten createZutat(@PathVariable String id, @RequestBody Zutaten zutaten){
        logger.info("POST request on route zutaten with {}", zutaten);
        zutaten.setListen(listenService.get(Long.valueOf(id)));
        return zutatenService.save(zutaten);
    }

    @CrossOrigin
    @GetMapping("/listen/{id}/zutaten")
    public Set<Zutaten> getAllZutaten(@PathVariable String id){
        logger.info("GET request on route zutaten with {}", id);
        Listen liste = listenService.get(Long.valueOf(id));
        return liste.getZutaten();
    }


    @CrossOrigin
    @GetMapping("/zutaten/{id}")
    public Zutaten getZutaten(@PathVariable String id) {
        logger.info("GET request on route zutaten with {}", id);
        Long zutatenId = Long.parseLong(id);
        return zutatenService.get(zutatenId);
    }
    @CrossOrigin
    @DeleteMapping("/zutaten/{id}")
    public void deleteZutat(@PathVariable Long id){
        zutatenService.delete(id);
    }
    @CrossOrigin
    @DeleteMapping("/listen/{id}/zutaten")
    public void deleteZutatenByListeId(@PathVariable Long id){
        zutatenService.deleteZutatenByListeId(id);
    }
}