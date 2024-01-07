package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ZutatenService {

    @Autowired
    ZutatenRepository repo;

    public Zutaten save(Zutaten zutaten){
        return repo.save(zutaten);
    }
    public void delete(Long id){
        repo.deleteById(id);
    }
    public Zutaten get (Long id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Zutaten> getAllWithoutOwner() {
        Iterable<Zutaten> iterator = repo.findAll();
        List<Zutaten> zutaten = new ArrayList<Zutaten>();
        for (Zutaten zutat : iterator) if(Objects.equals(zutat.getOwner(), "")) zutaten.add(zutat);
        return zutaten;
    }

    public List<Zutaten> getAllOwnedBy(String owner) {
        Iterable<Zutaten> iterator = repo.findAll();
        List<Zutaten> zutaten = new ArrayList<Zutaten>();
        for (Zutaten zutat : iterator) if(zutat.getOwner()!=null && zutat.getOwner().equals(owner)) zutaten.add(zutat);
        return zutaten;
    }
}