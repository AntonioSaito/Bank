package com.SaitoStore.SaitoBank.exceptions.AccountException;

public class MinimumWithdrawValueException extends RuntimeException{
    public MinimumWithdrawValueException(String message){
        super(message);
    }
}
