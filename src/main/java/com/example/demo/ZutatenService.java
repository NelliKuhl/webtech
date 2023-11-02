package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZutatenService {

    @Autowired
    ZutatenRepository repo;

    public Zutaten save(Zutaten zutaten){
        return repo.save(zutaten);
    }

    public Zutaten get (Long id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Zutaten> getAll(){
        Iterable<Zutaten> iterator = repo.findAll();
        List<Zutaten> zutatenListe = new ArrayList<>();
        for(Zutaten z: iterator) zutatenListe.add(z);
        return zutatenListe;
    }
}