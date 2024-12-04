package com.ticket.ticket.repositorie;

import com.ticket.ticket.model.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ReponseRepo extends JpaRepository<Reponse, Long> {
}
