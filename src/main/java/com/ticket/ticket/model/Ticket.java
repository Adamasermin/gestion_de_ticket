package com.ticket.ticket.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    private String description;

    private Date dateEnvoi;

    private String statut;

    @ManyToOne
    private Apprenant apprenant;

    @ManyToOne
    private Formateur formateur;

    @OneToOne
    private Reponse reponse;
}
