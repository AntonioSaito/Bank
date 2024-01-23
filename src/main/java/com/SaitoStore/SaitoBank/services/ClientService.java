package com.SaitoStore.SaitoBank.services;

import com.SaitoStore.SaitoBank.models.ClientModel;
import com.SaitoStore.SaitoBank.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public List<ClientModel> findAll(){
        return clientRepository.findAll();
    }

    @Transactional
    public ClientModel save(ClientModel clientModel){
        return clientRepository.save(clientModel);
    }

    @Transactional
    public Optional<ClientModel>findById(Long idClient){
        return clientRepository.findById(idClient);
    }

    @Transactional
    public void deleteByIdClient(Long idClient) {
        clientRepository.deleteById(idClient);
    }
}
