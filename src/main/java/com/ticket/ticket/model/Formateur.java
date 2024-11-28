package com.ticket.ticket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "formateur")
public class Formateur extends Users{

    private String specialite;

    @OneToMany(mappedBy = "formateur")
    private List<Ticket> ticketList;

}
