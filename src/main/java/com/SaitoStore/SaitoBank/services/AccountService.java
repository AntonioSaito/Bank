package com.SaitoStore.SaitoBank.services;

import com.SaitoStore.SaitoBank.Util.RandomNumber;
import com.SaitoStore.SaitoBank.dtos.AccountRecordDto;
import com.SaitoStore.SaitoBank.exceptions.AccountException.*;
import com.SaitoStore.SaitoBank.models.AccountModel;
import com.SaitoStore.SaitoBank.repositories.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

    private static final double MIN_DEPOSIT_AMOUNT = 10.0;
    private static final double MIN_WITHDRAW_AMOUNT = 10.0;
    private static final double MAX_WITHDRAW_AMOUNT = 10000.0;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionService transactionService;

    @Transactional
    public List<AccountModel> findAll() {
        return accountRepository.findAll();
    }

    @Transactional
    public AccountModel createAccount(AccountRecordDto accountRecordDto) {
        AccountModel account = new AccountModel();
        BeanUtils.copyProperties(accountRecordDto, account);
        account.setDateRegisterAccount(LocalDateTime.now());
        account.setNumberAccount((RandomNumber.generateAccountNumber()));
        return accountRepository.save(account);
    }

    @Transactional
    public AccountModel save(AccountModel clientModel) {
        return accountRepository.save(clientModel);
    }

    @Transactional
    public Optional<AccountModel> findById(UUID id) {
        Optional<AccountModel> accountModel = accountRepository.findById(id);
        if(accountModel.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(accountModel).getBody();
        }
        throw new AccountNotFoundException("Id account not found: " + id);
    }

    @Transactional
    public void deleteByIdAccount(UUID id) {
        Optional<AccountModel> account0 = accountRepository.findById(id);
        if (account0.isPresent()) {
            AccountModel account = account0.get();
            double balance = account.getBalance();
            if (balance > 10.0) {
                throw new PositiveBalanceException("Not possible, the account " + account.getNumberAccount() +
                        " has a positive balance.\nCurrent balance: " + account.getBalance());
            }
            accountRepository.deleteById(id);
        }
        else{
            throw new AccountNotFoundException("Id account not found: " + id);
        }
    }

    //Method that checks deposit rules
    @Transactional
    public void depositVerify(UUID id, double amount) {
        Optional<AccountModel> accountOptional = accountRepository.findById(id);
        if (accountOptional.isPresent()) {
            if (amount < MIN_DEPOSIT_AMOUNT) {
                throw new MinimumDepositValueException("The minimum amount deposit is: " + MIN_DEPOSIT_AMOUNT);
            }
        }
        if(accountOptional.isEmpty())
            throw new AccountNotFoundException("Id Account Not Found: " + id);
        }

    //method that deposits the balance into the account
    @Transactional
    public void deposit(UUID id, double amount) {

        depositVerify(id, amount);

        Optional<AccountModel> accountOptional = accountRepository.findById(id);
        AccountModel account = accountOptional.get();
        double currentBalance = account.getBalance();
        account.setBalance(currentBalance + amount);
        accountRepository.save(account);
    }

    @Transactional
    public void withdrawVerify(UUID id, double amount) {
        Optional<AccountModel> accountOptional = accountRepository.findById(id);
        AccountModel account = accountOptional.get();
        double currentBalance = account.getBalance();

        if (accountOptional.isPresent()) {
            if (amount > currentBalance) {
                throw new InsufficientBalanceWithdrawException("insufficient balance to withdraw.\nCurrent balance: "
                        + currentBalance);
            }
            if (amount < MIN_WITHDRAW_AMOUNT) {
                throw new MinimumWithdrawValueException("The minimum amount withdraw is: " + MIN_WITHDRAW_AMOUNT);
            }
            if (amount > MAX_WITHDRAW_AMOUNT) {
                throw new MaxWithdrawValueException("The maximum amount withdraw is: " + MAX_WITHDRAW_AMOUNT);
            }
        }

        if(accountOptional.isEmpty()) {
            throw new AccountNotFoundException("Id Account Not Found: " + id);
        }
    }

    @Transactional
    public void withdraw(UUID id, double amount) {

        withdrawVerify(id, amount);

        Optional<AccountModel> accountOptional = accountRepository.findById(id);
        AccountModel account = accountOptional.get();
        double currentBalance = account.getBalance();
        account.setBalance(currentBalance - amount);
        accountRepository.save(account);
    }
}