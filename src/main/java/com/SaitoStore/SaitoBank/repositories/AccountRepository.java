package com.SaitoStore.SaitoBank.repositories;

import com.SaitoStore.SaitoBank.models.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountModel, Long> {
}
