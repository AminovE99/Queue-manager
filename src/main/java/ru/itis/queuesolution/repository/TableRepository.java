package ru.itis.queuesolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.queuesolution.entity.Ticket;

public interface TableRepository extends JpaRepository<Ticket, Long> {
}
