package com.example.demo;

import com.example.demo.ListenPacket.Listen;
import com.example.demo.ListenPacket.ListenService;
import com.example.demo.ZutatenPacket.Zutaten;
import com.example.demo.ZutatenPacket.ZutatenController;
import com.example.demo.ZutatenPacket.ZutatenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ZutatenController.class)
public class ZutatenControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ZutatenService service;

    @MockBean
    private ListenService listenService;

    //geht nicht mit stÜck
    @Test
    public void testGetRoute() throws Exception {
        // Testdaten und Service Mock
        Listen liste = new Listen("Einkaufsliste", "");
        liste.setId(1L); // Setzen Sie die ID für die Liste
        Zutaten apfel = new Zutaten("Apfel", 2, "kg");
        apfel.setId(99L);
        apfel.setListen(liste);
        when(service.get(99L)).thenReturn(apfel);

        // Erwartetes Ergebnis
        String expected = "{\"id\":99,\"zutat\":\"Apfel\",\"menge\":2,\"einheit\":\"kg\",\"listen\":{\"id\":1,\"name\":\"Einkaufsliste\",\"owner\":\"\"}}";


        // Aufruf und Vergleich
        this.mockMvc.perform(get("/zutaten/99"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected));
    }
}
