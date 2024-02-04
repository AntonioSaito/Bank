package com.SaitoStore.SaitoBank.services;
import com.SaitoStore.SaitoBank.Util.RandomNumber;
import com.SaitoStore.SaitoBank.dtos.ClientRecordDto;
import com.SaitoStore.SaitoBank.models.ClientModel;
import com.SaitoStore.SaitoBank.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    @Transactional
    public List<ClientModel> findAll() {
        return clientRepository.findAll();
    }

    @Transactional
    public ClientModel save(ClientModel clientModel) {
        return clientRepository.save(clientModel);
    }

    @Transactional
    public ClientModel CreateClient(ClientRecordDto clientRecordDto) {
        ClientModel client = new ClientModel();
        BeanUtils.copyProperties(clientRecordDto, client);
        client.setDateRegisterClient(LocalDate.now());
        client.setNumberClient(RandomNumber.generateAccountNumber());
        return clientRepository.save(client);
    }

    @Transactional
    public Optional<ClientModel> findById(UUID id) {
        return clientRepository.findById(id);
    }

    @Transactional
    public void deleteByIdClient(UUID id) {
        clientRepository.deleteById(id);
    }}
