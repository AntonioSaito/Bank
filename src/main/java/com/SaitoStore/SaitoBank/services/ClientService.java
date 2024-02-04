package com.SaitoStore.SaitoBank.services;

import com.SaitoStore.SaitoBank.exceptions.ClientAgeException;
import com.SaitoStore.SaitoBank.models.ClientModel;
import com.SaitoStore.SaitoBank.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

        if(clientModel.getAge() < 0){
            throw new ClientAgeException();
        }
        return clientRepository.save(clientModel);
    }

    @Transactional
    public Optional<ClientModel>findById(UUID id){
        return clientRepository.findById(id);
    }

    @Transactional
    public void deleteByIdClient(UUID id) {
        clientRepository.deleteById(id);
    }

}


