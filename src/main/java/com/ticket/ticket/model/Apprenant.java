package com.ticket.ticket.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "apprenant")
public class Apprenant extends Users{

    private String formationSuivie;

    @ManyToOne
    private Formation formation;

    @OneToMany(mappedBy = "apprenant")
    private List<Ticket> ticket;
}
