package com.ticket.ticket.service;

import com.ticket.ticket.model.Apprenant;
import com.ticket.ticket.model.Formateur;
import com.ticket.ticket.repositorie.ApprenantRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ApprenantService {
    private final ApprenantRepo apprenantRepo;

    //Methode CRUD
    public Apprenant ajoutApprenant(Apprenant apprenant) {
        return apprenantRepo.save(apprenant);
    }

    public List<Apprenant> affichageApprenant() {
        return apprenantRepo.findAll();
    }

    public Apprenant modificationApprenant(Long id, Apprenant apprenant) {
        Optional<Apprenant> apprenant1 = apprenantRepo.findById(id);
        if(apprenant1.isPresent()) {
            Apprenant apprenantExistant = apprenant1.get();
            apprenantExistant.setNom(apprenant.getNom());
            apprenantExistant.setEmail(apprenant.getEmail());
            apprenantExistant.setMotDePasse(apprenant.getMotDePasse());
            apprenantExistant.setFormationSuivie(apprenant.getFormationSuivie());
            return apprenantRepo.save(apprenantExistant);
        } else {
            throw new EntityNotFoundException("L'apprenant avec l'ID " + id + " n'existe pas.");
        }

    }

    public String suppressionApprenant(Long id) {
        apprenantRepo.deleteById(id);
        return "Apprenant supprimé avec succès";
    }
}
