package com.SaitoStore.SaitoBank.controllers;
import com.SaitoStore.SaitoBank.dtos.ClientRecordDto;
import com.SaitoStore.SaitoBank.models.ClientModel;
import com.SaitoStore.SaitoBank.repositories.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public ResponseEntity<List<ClientModel>> getAllClients() { /*NÃO TEM RETORNO É SÓ CONSULTA NO BD*/
        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.findAll());
    }      //////////////*TA LINDO É SÓ APRENDEEEEEEEEER*/////////////////


    @PostMapping
    public ResponseEntity<ClientModel> registerClient(@RequestBody @Valid ClientRecordDto clientRecordDto) {  /*RequestBody está recebendo os dados Json digit no Postgree*/
        var clientModel = new ClientModel(); /*Inicie uma variavel ClientModel*/
        BeanUtils.copyProperties(clientRecordDto, clientModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientRepository.save(clientModel));
    }       /////////////////*TA LINDO É SÓ APRENDER*/////////////////////


    @GetMapping("/client/{id}")
    public ResponseEntity<ClientModel> getClientById(@PathVariable("id") long idClient) {
        Optional<ClientModel> client0 = clientRepository.findByIdClient(idClient);

        if (client0.isPresent()) {
            return new ResponseEntity<>(client0.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}