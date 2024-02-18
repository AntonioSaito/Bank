package com.SaitoStore.SaitoBank.controllers;

import com.SaitoStore.SaitoBank.exceptions.AccountException.*;
import com.SaitoStore.SaitoBank.exceptions.ClientException.ClientAgeException;
import com.SaitoStore.SaitoBank.exceptions.ClientException.ClientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InsufficientBalanceWithdrawException.class)
        public ResponseEntity<Object> handlerInsufficientBalanceWithdrawException(InsufficientBalanceWithdrawException ex){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<Object>handlerClientNotFoundException(ClientNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<Object>handlerAccountNotFoundException(AccountNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(MinimumDepositValueException.class)
    public ResponseEntity<Object>handlerMinimumDepositValueException(MinimumDepositValueException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(MinimumWithdrawValueException.class)
    public ResponseEntity<Object>handlerMinimumWithdrawValueException(MinimumWithdrawValueException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(MaxWithdrawValueException.class)
    public ResponseEntity<Object>handlerMaxWithdrawValueException(MaxWithdrawValueException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(ClientAgeException.class)
    public ResponseEntity<Object>handlerClientAgeException(ClientAgeException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<Object>handlerInsufficientBalanceException(InsufficientBalanceException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    }
