package com.example.demo.ListenPacket;

import com.example.demo.ListenPacket.Listen;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListenRepository extends CrudRepository<Listen, Long> {}