package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class ZutatenServiceTest {

    @Autowired
    private ZutatenService service;

    @MockBean
    private ZutatenRepository repository;

    @Test
    @DisplayName("Sollte Zutat mit Hilfe der ID finden")
    void testGet() {
        var z1 = new Zutaten("Pfeffer", 99, "Gramm", "Marie");
        var z2 = new Zutaten("Mehl", 199, "Gramm", "Nelli");
        doReturn(Optional.of(z1)).when(repository).findById(42L);
        doReturn(Optional.of(z2)).when(repository).findById(43L);

        Zutaten actual = service.get(42L);

        assertEquals(actual.getZutat(), "Pfeffer");
    }
}
