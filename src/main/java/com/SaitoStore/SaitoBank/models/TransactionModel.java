package com.SaitoStore.SaitoBank.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="transactions")
public class TransactionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name="origin_Account")
    private AccountModel originAccount;

    @ManyToOne
    @JoinColumn
    private AccountModel destinyAccount;

    private double amount;
    private LocalDateTime dateTimeTransaction;

}
