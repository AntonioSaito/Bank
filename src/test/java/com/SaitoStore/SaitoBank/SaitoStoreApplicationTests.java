package com.SaitoStore.SaitoBank;

import com.SaitoStore.SaitoBank.controllers.ClientController;
import com.SaitoStore.SaitoBank.exceptions.ClientAgeException;
import com.SaitoStore.SaitoBank.models.ClientModel;
import com.SaitoStore.SaitoBank.services.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SaitoStoreApplicationTests {

	@Mock
	private ClientService clientService;

	@InjectMocks
	private ClientController clientController;

	@Test
	public void registerClientTest(){


	}

	}
