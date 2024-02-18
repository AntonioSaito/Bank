package com.SaitoStore.SaitoBank.exceptions.AccountException;

public class PositiveBalanceException extends RuntimeException{

    public PositiveBalanceException(String message){
        super(message);
    }
}
