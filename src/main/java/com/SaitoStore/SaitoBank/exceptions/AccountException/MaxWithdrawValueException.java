package com.SaitoStore.SaitoBank.exceptions.AccountException;

public class MaxWithdrawValueException extends RuntimeException{
    public MaxWithdrawValueException(String message){
        super(message);
    }
}
