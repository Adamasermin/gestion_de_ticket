package com.ticket.ticket.repositorie;

import com.ticket.ticket.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface FormationRepo extends JpaRepository<Formation, Long> {
}
