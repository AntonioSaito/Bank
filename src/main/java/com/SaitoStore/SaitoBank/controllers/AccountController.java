package com.SaitoStore.SaitoBank.controllers;

import com.SaitoStore.SaitoBank.dtos.AccountRecordDto;
import com.SaitoStore.SaitoBank.models.AccountModel;
import com.SaitoStore.SaitoBank.models.ClientModel;
import com.SaitoStore.SaitoBank.services.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountModel>> getAllAccount() {
        List<AccountModel> accountList = accountService.findAll();
        for(AccountModel account : accountList){
            UUID id = account.getId();
            account.add(linkTo(methodOn(AccountController.class).getByAccountId(id)).withSelfRel());
        }
        return new ResponseEntity<List<AccountModel>>(accountList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountModel>getByAccountId(@PathVariable ("id") UUID id){
        Optional<AccountModel> account0 = accountService.findById(id);
        account0.get().add(linkTo(methodOn(AccountController.class).getAllAccount()).withSelfRel());
        return new ResponseEntity<>(account0.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createAccount(@RequestBody @Valid AccountRecordDto accountRecordDto) {
        AccountModel createdAccount = accountService.createAccount(accountRecordDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteAccountById(@PathVariable("id") UUID id) {
        Optional<AccountModel> account0 = accountService.findById(id);
        accountService.deleteByIdAccount(id);
        return ResponseEntity.status(HttpStatus.OK).body("Delete");
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<Object> depositAccount(@PathVariable ("id") UUID id,
                                                  @RequestBody Map<String, Double> requestBody){
            double amount = requestBody.get("amount");
            accountService.deposit(id,amount);
            return ResponseEntity.ok().body("Deposit Successful");
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<Object> withdrawAccount(@PathVariable ("id") UUID id,
                                                  @RequestBody Map<String, Double> requestBody){
        double amount = requestBody.get("amount");
        accountService.withdraw(id, amount);
        return ResponseEntity.ok().body("Withdraw Successful");
    }

}
