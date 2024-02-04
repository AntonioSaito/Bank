package com.SaitoStore.SaitoBank.controllers;

import com.SaitoStore.SaitoBank.dtos.AccountRecordDto;
import com.SaitoStore.SaitoBank.models.AccountModel;
import com.SaitoStore.SaitoBank.repositories.AccountRepository;
import com.SaitoStore.SaitoBank.services.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<AccountModel> getAllAccount() {
        return accountService.findAll();
    }

    @PostMapping
    public AccountModel createAccount(@RequestBody @Valid AccountRecordDto accountRecordDto) {
        var account = new AccountModel();
        BeanUtils.copyProperties(accountRecordDto, account);
        account.setDateRegisterAccount(LocalDateTime.now());
        Random random = new Random();
        int accountRandomNumber = 1000 + random.nextInt(9000);
        account.setNumberAccount(String.valueOf(accountRandomNumber));
        return accountService.save(account);
    }
}
