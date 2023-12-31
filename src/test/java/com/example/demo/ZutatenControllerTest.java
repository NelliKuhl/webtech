package com.example.demo;

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

    //geht nicht mit stÜck
    @Test
    public void testGetRoute() throws Exception {
        //Test Daten und Service Mock
        Zutaten apfel = new Zutaten("Apfel", 2, "kg", "Marie");
        apfel.setId(99L);
        when(service.get(99L)).thenReturn(apfel);

        //Erwartetes Ergebnis
        String expected = "{\"id\":99,\"zutat\":\"Apfel\",\"menge\":2,\"einheit\":\"kg\",\"owner\":\"Marie\"}";

        //Aufruf und Vergleich
        this.mockMvc.perform(get("/zutaten/99"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString(expected)));
    }
}
