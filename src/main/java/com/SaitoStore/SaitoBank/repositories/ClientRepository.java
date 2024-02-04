package com.SaitoStore.SaitoBank.repositories;

import com.SaitoStore.SaitoBank.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, UUID>{

}