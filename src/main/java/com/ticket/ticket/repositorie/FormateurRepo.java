package com.ticket.ticket.repositorie;

import com.ticket.ticket.model.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface FormateurRepo extends JpaRepository<Formateur, Long> {
}
