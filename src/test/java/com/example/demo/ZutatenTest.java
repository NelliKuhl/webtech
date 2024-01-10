package com.example.demo;

import com.example.demo.ZutatenPacket.Zutaten;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ZutatenTest {

    @Test
    void testToString(){

        //Objekt erstellen
        Zutaten apfel = new Zutaten("Apfel", 2, "Stück", "Nelli");
        apfel.setId(99L);

        //erwartetes Ergebnis
        String expected= "Zutat{ID=99, Zutat='Apfel', Menge=2, Einheit='Stück'}";

        //tatsächliches Ergebnis
        String actual= apfel.toString();

        //Vergleich
        assertEquals(expected, actual);

    }
}
