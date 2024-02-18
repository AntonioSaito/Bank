package com.SaitoStore.SaitoBank;

import com.SaitoStore.SaitoBank.models.ClientModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class ClientModelTest {

    @Test
    public void variableClientTest() {

        ClientModel clientModel = new ClientModel();
        clientModel.setId(UUID.randomUUID());
        clientModel.setDateRegisterClient(LocalDate.now());
        clientModel.setName("Cristiano Ronaldo");
        clientModel.setAge(39);
        clientModel.setEmail("Cristiano@gmail.com");
        clientModel.setNumberClient(String.valueOf(5425));


        Assertions.assertEquals("Cristiano Ronaldo", clientModel.getName());
        Assertions.assertEquals(39, clientModel.getAge());
        Assertions.assertEquals("Cristiano@gmail.com", clientModel.getEmail());
        Assertions.assertEquals(String.valueOf(5425), clientModel.getNumberClient());


    }
}
