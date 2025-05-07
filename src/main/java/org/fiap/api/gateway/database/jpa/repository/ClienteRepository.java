package org.fiap.api.gateway.database.jpa.repository;

import org.fiap.api.gateway.database.jpa.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
   Optional<ClienteEntity> findByCpf(String cpf);
}
