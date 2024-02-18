package com.SaitoStore.SaitoBank.exceptions.AccountException;

public class InsufficientBalanceWithdrawException extends RuntimeException{

    public InsufficientBalanceWithdrawException(String message){
        super(message);
    }
}
