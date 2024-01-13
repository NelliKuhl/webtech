package com.example.demo.ListenTestPacket;

import com.example.demo.ListenPacket.Listen;
import com.example.demo.ListenPacket.ListenRepository;
import com.example.demo.ListenPacket.ListenService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class ListenServiceTest {

    @Autowired
    private ListenService service;

    @MockBean
    private ListenRepository repository;

    @Test
    @DisplayName("Sollte Liste mit Hilfe der ID finden")
    void testGet() {
      var l1 = new Listen("REWE", "test");
      var l2 = new Listen("Edeka", "test");
        doReturn(Optional.of(l1)).when(repository).findById(1L);
        doReturn(Optional.of(l2)).when(repository).findById(2L);

        Listen actual = service.get(1L);

        assertEquals(actual.getName(), "REWE");
    }

    @Test
    @DisplayName("testet die Methode getAllOwnedBy")
    void testGetAllOwnedBy() {
      var l1 = new Listen("REWE", "test");
      l1.setId(1L);
        doReturn(Collections.singletonList(l1)).when(repository).findAll();

        List <Listen> actual = service.getAllOwnedBy("test");

        List <Listen> expected = new ArrayList<>();
        expected.add(new Listen("REWE", "test"));
        expected.get(0).setId(1L);

        assertEquals(expected, actual);

    }
}
