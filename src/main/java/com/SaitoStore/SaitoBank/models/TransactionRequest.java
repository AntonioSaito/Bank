package com.SaitoStore.SaitoBank.models;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TransactionRequest {
        private UUID originAccount;
        private UUID destinyAccount;
        private double amount;
}
