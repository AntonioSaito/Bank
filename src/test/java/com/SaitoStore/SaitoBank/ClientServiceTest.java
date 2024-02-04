package com.SaitoStore.SaitoBank;

import com.SaitoStore.SaitoBank.models.ClientModel;
import com.SaitoStore.SaitoBank.repositories.ClientRepository;
import com.SaitoStore.SaitoBank.services.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;

public class ClientServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void RegisterClient(){

    }

}
