package com.SaitoStore.SaitoBank.exceptions.ClientException;

public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException(String message){
        super(message);
    }
}
