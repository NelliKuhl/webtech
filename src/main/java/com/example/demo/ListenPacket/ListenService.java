package com.example.demo.ListenPacket;



import com.example.demo.ZutatenPacket.ZutatenRepository;
import com.example.demo.ZutatenPacket.ZutatenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ListenService {

    @Autowired
    ListenRepository listenRepo;

    @Autowired
    ZutatenRepository zutatenRepo;



    public Listen save(Listen listen){
        return listenRepo.save(listen);
    }
    public void delete(Long id){
        listenRepo.deleteById(id);
    }


    public Listen get (Long id){
        return listenRepo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Listen> getAllWithoutOwner() {
        Iterable<Listen> iterator = listenRepo.findAll();
        List<Listen> listen = new ArrayList<Listen>();
        for (Listen liste : iterator) if(Objects.equals(liste.getOwner(), "")) listen.add(liste);
        return listen;
    }

    public List<Listen> getAllOwnedBy(String owner) {
        Iterable<Listen> iterator = listenRepo.findAll();
        List<Listen> listen = new ArrayList<Listen>();
        for (Listen liste : iterator) if(liste.getOwner()!=null && liste.getOwner().equals(owner)) listen.add(liste);
        return listen;
    }
}