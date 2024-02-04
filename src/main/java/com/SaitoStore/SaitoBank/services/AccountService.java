package com.SaitoStore.SaitoBank.services;

import com.SaitoStore.SaitoBank.models.AccountModel;
import com.SaitoStore.SaitoBank.repositories.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public List<AccountModel>findAll(){
        return accountRepository.findAll();
    }

    @Transactional
    public AccountModel save(AccountModel accountModel){
        Random random = new Random();
        int accountNumber = 1000 + random.nextInt(9000); //Generate random number
        return accountRepository.save(accountModel);
    }

    @Transactional
    public Optional<AccountModel> findById(UUID id){
        return accountRepository.findById(id);
    }

    @Transactional
    public void deleteByIdClient(UUID id) {
        accountRepository.deleteById(id);
    }


}
