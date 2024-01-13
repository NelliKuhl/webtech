package com.example.demo.ZutatenTestPacket;

import com.example.demo.ZutatenPacket.Zutaten;
import com.example.demo.ZutatenPacket.ZutatenRepository;
import com.example.demo.ZutatenPacket.ZutatenService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
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
        var z1 = new Zutaten("Pfeffer", 1, "Packung/en");
        var z2 = new Zutaten("Mehl", 500, "Gramm");
        doReturn(Optional.of(z1)).when(repository).findById(1L);
        doReturn(Optional.of(z2)).when(repository).findById(2L);

        Zutaten actual = service.get(1L);

        assertEquals(actual.getZutat(), "Pfeffer");
    }

    @Test
    @DisplayName("Sollte Zutat mit Hilfe der ID löschen")
    void testDelete() {
        var z1 = new Zutaten("Pfeffer", 1, "Packung/en");
        z1.setId(1L);

        doNothing().when(repository).deleteById(1L);

        service.delete(1L);

        //erwartet wird eine RuntimeException, da die Zutat mit der ID 1 gelöscht wurde
        assertThrows(RuntimeException.class, () -> {service.get(1L);});
    }

}
