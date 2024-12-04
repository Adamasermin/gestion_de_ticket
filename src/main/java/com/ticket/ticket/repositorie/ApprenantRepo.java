package com.ticket.ticket.repositorie;

import com.ticket.ticket.model.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ApprenantRepo extends JpaRepository<Apprenant, Long> {
}
