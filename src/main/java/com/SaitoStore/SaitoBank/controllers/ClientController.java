package com.SaitoStore.SaitoBank.controllers;
import ch.qos.logback.core.net.server.Client;
import com.SaitoStore.SaitoBank.dtos.ClientRecordDto;
import com.SaitoStore.SaitoBank.models.ClientModel;
import com.SaitoStore.SaitoBank.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/client")
public class ClientController {


    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientModel>> getAllClients() {
        List<ClientModel> clientList = clientService.findAll();
        for(ClientModel client : clientList){
            UUID id = client.getId();
            client.add(linkTo(methodOn(ClientController.class).getClientById(id)).withSelfRel());
        }
        return new ResponseEntity<List<ClientModel>>(clientList,HttpStatus.OK);
            }

    @GetMapping("/{id}")
    public ResponseEntity<ClientModel> getClientById(@PathVariable("id") UUID id) {
        Optional<ClientModel> client0 = clientService.findById(id);
        client0.get().add(linkTo(methodOn(ClientController.class).getAllClients()).withSelfRel());
        return new ResponseEntity<>(client0.get(), HttpStatus.OK);
    }

    @PostMapping
        public ResponseEntity<Object> registerClient(@RequestBody @Valid ClientRecordDto clientRecordDto) {
            return ResponseEntity.status(HttpStatus.CREATED).body(clientService.CreateClient(clientRecordDto));
        }


    @PutMapping("/{id}")
    public ResponseEntity<Object> updateClient (@PathVariable("id") UUID id, @RequestBody ClientRecordDto clientRecordDto){
        Optional<ClientModel>client0 = clientService.findById(id);
        var clientModel = client0.get();
        BeanUtils.copyProperties(clientRecordDto, clientModel);
        return ResponseEntity.status(HttpStatus.OK).body(clientService.save(clientModel));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClientById(@PathVariable("id") UUID id) {
        Optional<ClientModel> client0 = clientService.findById(id);
        clientService.deleteByIdClient(id);
        return ResponseEntity.status(HttpStatus.OK).body("Delete");
    }
}