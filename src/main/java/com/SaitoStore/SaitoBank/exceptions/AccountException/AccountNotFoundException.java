package com.SaitoStore.SaitoBank.exceptions.AccountException;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String message){
        super(message);
    }
}
