package com.ticket.ticket.controller;

import com.ticket.ticket.model.Ticket;
import com.ticket.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/ajout")
    public Ticket ajout(@RequestBody Ticket ticket) {
        return ticketService.ajoutTicket(ticket);
    }

    @GetMapping("/liste")
    public List<Ticket> lister() {
        return ticketService.affichageTicket();
    }

    @PutMapping("/update/{id}")
    public Ticket update(@PathVariable Long id, @RequestBody Ticket ticket) {
        return ticketService.modificationTicket(id, ticket);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return ticketService.suppressionTicket(id);
    }
}
