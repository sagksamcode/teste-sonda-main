package br.com.elo7.sonda.candidato.services.controllers;

import br.com.elo7.sonda.candidato.builders.ProbePostResponseBuilder;
import br.com.elo7.sonda.candidato.builders.ProbeResponseBuilder;
import br.com.elo7.sonda.candidato.domains.models.vos.requests.ProbeRequest;
import br.com.elo7.sonda.candidato.domains.models.vos.responses.ProbePostResponse;
import br.com.elo7.sonda.candidato.domains.models.vos.responses.ProbeResponse;
import br.com.elo7.sonda.candidato.services.ProbeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class ProbeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProbeService probeService;

    @Test
    void findOne() throws Exception {
        // Mock the service response
        ProbeResponse probeResponse = new ProbeResponseBuilder().withId(1L)
                        .build();
        when(probeService.getById(anyLong())).thenReturn(probeResponse);

        // Perform the request and assert the response
        mockMvc.perform(MockMvcRequestBuilders.get("/probes/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));
    }

    @Test
    void findAll() throws Exception {
        List<ProbeResponse> probeResponses = Arrays.asList(new ProbeResponse());
        when(probeService.findAll()).thenReturn(probeResponses);

        mockMvc.perform(MockMvcRequestBuilders.get("/probes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }

    @Test
    void create() throws Exception {
        // Mock the service response
        ProbePostResponse probePostResponse = new ProbePostResponseBuilder().withId(1L)
                        .build();
        when(probeService.insert(any(ProbeRequest.class))).thenReturn(probePostResponse);

        // Perform the request and assert the response
        mockMvc.perform(MockMvcRequestBuilders.post("/probes")
                        .content("{\"id\": 1 }")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));
    }

    @Test
    void commands() throws Exception {
        ProbePostResponse probePostResponse = new ProbePostResponseBuilder().withId(1L)
                        .build();
        when(probeService.processesCommands(anyLong(), any(List.class))).thenReturn(probePostResponse);

        mockMvc.perform(MockMvcRequestBuilders.put("/probes/commands")
                        .content("{\"probeId\": 1, \"commands\": [\"M\", \"M\", \"R\", \"M\", \"M\", \"R\", \"M\", \"R\", \"R\", \"M\", \"L\"]}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L));
    }



}
