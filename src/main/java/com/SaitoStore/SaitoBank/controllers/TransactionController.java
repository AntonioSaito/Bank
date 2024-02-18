package com.SaitoStore.SaitoBank.controllers;

import com.SaitoStore.SaitoBank.models.TransactionModel;
import com.SaitoStore.SaitoBank.models.TransactionRequest;
import com.SaitoStore.SaitoBank.services.TransactionService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transfer")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<TransactionModel>> getAllTransfer(){
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.getAllTransaction());
    }

    @PostMapping
    public ResponseEntity<Object> transfer(@RequestBody TransactionRequest transactionRequest) {
        transactionService.transfer(transactionRequest.getOriginAccount(), transactionRequest.getDestinyAccount(), transactionRequest.getAmount());
        return ResponseEntity.status(HttpStatus.OK).body("Transfer Successful");
    }



}
