package com.SaitoStore.SaitoBank;

import com.SaitoStore.SaitoBank.controllers.ClientController;
import com.SaitoStore.SaitoBank.dtos.ClientRecordDto;
import com.SaitoStore.SaitoBank.models.ClientModel;
import com.SaitoStore.SaitoBank.services.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ClientService clientService;

    @Autowired
    private ObjectMapper objectMapper;

    UUID randomId = UUID.randomUUID();

    @Test
    @DisplayName("Checks a query client Id")
    void getClientByIdTest() throws Exception {

        ClientModel clientModel = new ClientModel();
        clientModel.setId(randomId);
        clientModel.setName("João");
        clientModel.setAge(19);
        clientModel.setEmail("joão@gmail.com");

        when(clientService.findById(randomId)).thenReturn(Optional.of(clientModel));
        mockMvc.perform(get("/client/{id}", randomId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(randomId.toString()))
                .andExpect(jsonPath("$.name").value("João"))
                .andExpect(jsonPath("$.age").value(19))
                .andExpect(jsonPath("$.email").value("joão@gmail.com"));
    }

    @Test
    @DisplayName("Checks the deletion of an existing customer")
    void deleteClientByIdTest() throws Exception{
    mockMvc.perform(MockMvcRequestBuilders.delete("/client/{id}", randomId)
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }


}
