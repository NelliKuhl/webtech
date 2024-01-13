package com.example.demo.ListenTestPacket;


import com.example.demo.ListenPacket.Listen;
import com.example.demo.ListenPacket.ListenController;
import com.example.demo.ListenPacket.ListenService;

import com.example.demo.ZutatenPacket.ZutatenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ListenController.class)
public class ListenControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ListenService listenService;


    @Test
    public void testGetRoute() throws Exception {
        // Testdaten und Service Mock
        Listen liste = new Listen("Einkaufsliste", "");
        liste.setId(1L); // Setzen Sie die ID für die Liste
        when(listenService.get(1L)).thenReturn(liste);

        // Erwartetes Ergebnis
        String expected = "{\"id\":1,\"name\":\"Einkaufsliste\",\"owner\":\"\"}";


        // Aufruf und Vergleich
        this.mockMvc.perform(get("/listen/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expected));
    }

}

