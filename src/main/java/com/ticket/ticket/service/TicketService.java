package com.ticket.ticket.service;

import com.ticket.ticket.model.Formation;
import com.ticket.ticket.model.Ticket;
import com.ticket.ticket.repositorie.TicketRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepo ticketRepo;

    //Methode CRUD
    public Ticket ajoutTicket(Ticket ticket) {
        return ticketRepo.save(ticket);
    }

    public List<Ticket> affichageTicket() {
        return ticketRepo.findAll();
    }

    public Ticket modificationTicket(Long id, Ticket ticket) {
        Optional<Ticket> ticket1 = ticketRepo.findById(id);
        if(ticket1.isPresent()) {
            Ticket ticketExistante = ticket1.get();
            ticketExistante.setTitre(ticket.getTitre());
            ticketExistante.setDescription(ticket.getDescription());
            ticketExistante.setStatut(ticket.getStatut());
            return ticketRepo.save(ticketExistante);
        } else {
            // Lance une exception si l'ID n'existe pas
            throw new EntityNotFoundException("Le ticket avec l'ID " + id + " n'existe pas.");
        }
    }

    public String suppressionTicket(Long id) {
        ticketRepo.deleteById(id);
        return "Ticket supprimé avec succès";
    }


}
