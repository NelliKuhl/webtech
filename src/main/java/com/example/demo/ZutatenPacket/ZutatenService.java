package com.example.demo.ZutatenPacket;

import com.example.demo.ListenPacket.ListenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ZutatenService {

    @Autowired
    ZutatenRepository zutatenRepo;

    @Autowired
    ListenRepository listenRepo;

    public Zutaten save(Zutaten zutaten){
        return zutatenRepo.save(zutaten);
    }
    public void delete(Long id){
        zutatenRepo.deleteById(id);
    }

    public void deleteZutatenByListeId(Long listeId) {
        Iterable<Zutaten> iterator = zutatenRepo.findAll();
        List<Zutaten> zutaten = new ArrayList<Zutaten>();
        for (Zutaten zutat : iterator) if(Objects.equals(zutat.getListen().getId(), listeId)) zutaten.add(zutat);
        zutatenRepo.deleteAll(zutaten);
    }
    public Zutaten get (Long id){
        return zutatenRepo.findById(id).orElseThrow(() -> new RuntimeException());
    }




}