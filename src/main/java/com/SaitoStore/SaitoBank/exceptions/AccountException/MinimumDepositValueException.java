package com.SaitoStore.SaitoBank.exceptions.AccountException;

public class MinimumDepositValueException extends RuntimeException{
    public MinimumDepositValueException(String message){
        super(message);
    }
}
