package com.SaitoStore.SaitoBank.services;

import com.SaitoStore.SaitoBank.exceptions.AccountException.AccountNotFoundException;
import com.SaitoStore.SaitoBank.exceptions.AccountException.InsufficientBalanceException;
import com.SaitoStore.SaitoBank.models.AccountModel;
import com.SaitoStore.SaitoBank.models.TransactionModel;
import com.SaitoStore.SaitoBank.repositories.AccountRepository;
import com.SaitoStore.SaitoBank.repositories.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public List<TransactionModel> getAllTransaction (){
        return transactionRepository.findAll();
    }


    @Transactional
    public TransactionModel transfer (UUID originAccountModelId, UUID destinyAccountModelId, double amount) {

            transferVerify(originAccountModelId, destinyAccountModelId, amount);

            AccountModel originAccount0 = accountRepository.findById(originAccountModelId).orElse(null);
            AccountModel destinyAccount0 = accountRepository.findById(destinyAccountModelId).orElse(null);

            originAccount0.setBalance(originAccount0.getBalance() - amount);
            destinyAccount0.setBalance(destinyAccount0.getBalance() + amount);

            accountRepository.save(originAccount0);
            accountRepository.save(destinyAccount0);

            //Salva o extrato
            TransactionModel transactionModel = new TransactionModel();
            transactionModel.setOriginAccount(originAccount0);
            transactionModel.setDestinyAccount(destinyAccount0);
            transactionModel.setAmount(amount);
            transactionModel.setDateTimeTransaction(LocalDateTime.now());

            return transactionRepository.save(transactionModel);
        }


    @Transactional
    public void transferVerify(UUID originAccountId, UUID destinyAccountId, double amount){

        AccountModel originAccountVerify = accountRepository.findById(originAccountId).orElse(null);
        AccountModel destinyAccountVerify = accountRepository.findById(destinyAccountId).orElse(null);

        if(originAccountVerify == null){
            throw new AccountNotFoundException("Origin Account not found: " + originAccountId);
        }
        if(destinyAccountVerify == null){
            throw new AccountNotFoundException("Destiny Account not found: " + originAccountId);
        }
        if (originAccountVerify.getBalance() < amount){
            throw new InsufficientBalanceException("Insufficient balance.\n" +
                                                    "Current balance: " + originAccountVerify.getBalance());
        }
    }

}
