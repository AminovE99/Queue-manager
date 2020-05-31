package ru.itis.queuesolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.queuesolution.entity.Client;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByEmail(String email);
}
