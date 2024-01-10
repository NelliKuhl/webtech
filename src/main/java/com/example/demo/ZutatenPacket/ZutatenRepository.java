package com.example.demo.ZutatenPacket;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZutatenRepository extends CrudRepository<Zutaten, Long> {
}