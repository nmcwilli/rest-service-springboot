package com.example.restservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
@AutoConfigureMockMvc
public class ClientsControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClientRepository ClientRepository;

    @Test
    public void testGetClients() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/clients"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testCreateClient() throws Exception {
        Client client = new Client("Test Name", "test@example.com");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/clients")
                        .content(asJsonString(client))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    // Add similar test methods for other controller methods

    // Utility method to convert objects to JSON strings
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
