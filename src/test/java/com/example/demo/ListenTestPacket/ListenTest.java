package com.example.demo.ListenTestPacket;

import com.example.demo.ListenPacket.Listen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListenTest {

    @Test
    void testToString(){

        //Objekt erstellen
        Listen rewe = new Listen("REWE",  "");
        rewe.setId(1L);

        //erwartetes Ergebnis
        String expected= "Listen{ID=1, Name='REWE'}";

        //tatsächliches Ergebnis
        String actual= rewe.toString();

        //Vergleich
        assertEquals(expected, actual);
    }
}
