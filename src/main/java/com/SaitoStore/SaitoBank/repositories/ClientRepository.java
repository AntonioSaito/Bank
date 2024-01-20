package com.SaitoStore.SaitoBank.repositories;

import com.SaitoStore.SaitoBank.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientModel, Long>{
    Optional<ClientModel> findByIdClient(long idClient);
}