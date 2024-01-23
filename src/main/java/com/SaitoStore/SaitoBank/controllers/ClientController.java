package com.SaitoStore.SaitoBank.controllers;
import com.SaitoStore.SaitoBank.dtos.ClientRecordDto;
import com.SaitoStore.SaitoBank.models.ClientModel;
import com.SaitoStore.SaitoBank.repositories.ClientRepository;
import com.SaitoStore.SaitoBank.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientModel>> getAllClients() {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findAll());
    }


    @PostMapping
    public ResponseEntity<Object> registerClient(@RequestBody @Valid ClientRecordDto clientRecordDto) {
        var clientModel = new ClientModel();
        BeanUtils.copyProperties(clientRecordDto, clientModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(clientModel));
    }


    @GetMapping("/{id}")
    public ResponseEntity<ClientModel> getClientById(@PathVariable("id") long idClient) {
        Optional<ClientModel> client0 = clientService.findById(idClient);
        if (client0.isPresent()) {
            return new ResponseEntity<>(client0.get(), HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClient (@PathVariable("id") long idClient, @RequestBody ClientRecordDto clientRecordDto){
        Optional<ClientModel>client0 = clientService.findById(idClient);
        var clientModel = client0.get();
        BeanUtils.copyProperties(clientRecordDto, clientModel);
        return ResponseEntity.status(HttpStatus.OK).body(clientService.save(clientModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClientById(@PathVariable("id") long idClient) {
        Optional<ClientModel> client0 = clientService.findById(idClient);
        clientService.deleteByIdClient(idClient);
        return ResponseEntity.status(HttpStatus.OK).body("Delete");
    }
}