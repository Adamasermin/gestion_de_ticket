package com.ticket.ticket.service;

import com.ticket.ticket.model.Formateur;
import com.ticket.ticket.model.Ticket;
import com.ticket.ticket.repositorie.FormateurRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FormateurService {

    private final FormateurRepo formateurRepo;

    //Methode CRUD
    public Formateur ajoutFormateur(Formateur formateur) {
        if (formateur.getRole() == null || !formateur.getRole().equals("FORMATEUR")) {
            formateur.setRole("FORMATEUR");
        }
        return formateurRepo.save(formateur);
    }

    public List<Formateur> affichageFormateur() {
        return formateurRepo.findAll();
    }

    public Formateur modificationFormateur(Long id, Formateur formateur) {
        Optional<Formateur> formateur1 = formateurRepo.findById(id);
        if(formateur1.isPresent()) {
            Formateur formateurExistant = formateur1.get();
            formateurExistant.setNom(formateur.getNom());
            formateurExistant.setEmail(formateur.getEmail());
            formateurExistant.setMotDePasse(formateur.getMotDePasse());
            formateurExistant.setSpecialite(formateur.getSpecialite());
            return formateurRepo.save(formateurExistant);
        } else {
            throw new EntityNotFoundException("Le formateur avec l'ID " + id + " n'existe pas.");
        }

    }

    public String suppressionFormateur(Long id) {
        formateurRepo.deleteById(id);
        return "Formateur supprimé avec succès";
    }
}
