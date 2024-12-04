package com.ticket.ticket.repositorie;

import com.ticket.ticket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TicketRepo extends JpaRepository<Ticket, Long> {
}
