package com.SaitoStore.SaitoBank.repositories;

import com.SaitoStore.SaitoBank.models.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<TransactionModel, UUID> {
}
