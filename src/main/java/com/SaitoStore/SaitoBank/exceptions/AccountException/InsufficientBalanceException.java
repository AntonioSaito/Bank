package com.SaitoStore.SaitoBank.exceptions.AccountException;

public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(String message){
        super(message);
    }
}
