package com.ticket.ticket.repositorie;

import com.ticket.ticket.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepo extends JpaRepository<Formation, Long> {
}
