package br.com.elo7.sonda.candidato.services.controllers;

import br.com.elo7.sonda.candidato.builders.PlanetPostResponseBuilder;
import br.com.elo7.sonda.candidato.builders.PlanetResponseBuilder;

import br.com.elo7.sonda.candidato.domains.models.vos.requests.PlanetRequest;
import br.com.elo7.sonda.candidato.services.PlanetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class PlanetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlanetService planetService;

    @Test
    void testFindOne() throws Exception {
        // Mock the service response
        when(planetService.getById(1L)).thenReturn(new PlanetResponseBuilder().withId(1L).build());

        // Perform the request and assert the response
        mockMvc.perform(MockMvcRequestBuilders.get("/planets/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));
        // Add more assertions based on your expected response
    }

    @Test
    void testFindAll() throws Exception {
        // Mock the service response
        when(planetService.findAll()).thenReturn(Collections.singletonList(new PlanetResponseBuilder().withId(1L).build()));

        // Perform the request and assert the response
        mockMvc.perform(MockMvcRequestBuilders.get("/planets")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
        // Add more assertions based on your expected response
    }

    @Test
    void testAdd() throws Exception {
        // Mock the service response
        when(planetService.insert(any(PlanetRequest.class))).thenReturn(new PlanetPostResponseBuilder().withId(1L).build());

        // Perform the request and assert the response
        mockMvc.perform(MockMvcRequestBuilders.post("/planets")
                        .content("{\"id\": 1, \"name\": \"Plutao\", \"width\": 5, \"height\": 5}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));
        // Add more assertions based on your expected response
    }

//    @Test
//    void testUpdate() throws Exception {
//        // Mock the service response
//        when(planetService.update(1L, new PlanetRequest()))
//                .thenReturn(new PlanetPostResponseBuilder().withId(1L).build());
//
//        // Perform the request and assert the response
//        mockMvc.perform(MockMvcRequestBuilders.put("/planets/1")  // Change from post to put
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"name\": \"Plutao\", \"width\": 5, \"height\": 5}")) // Add your request payload here
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));
//    }
}
