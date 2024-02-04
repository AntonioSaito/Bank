package com.SaitoStore.SaitoBank.exceptions;

public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException(String message){
        super(message);
    }

}
