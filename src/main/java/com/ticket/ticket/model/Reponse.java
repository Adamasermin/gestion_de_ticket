package com.ticket.ticket.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "reponse")
@Data
@NoArgsConstructor
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contenu;

    private Date dateEnvoi;

    @OneToOne(mappedBy = "reponse")
    private Ticket ticket;
}
