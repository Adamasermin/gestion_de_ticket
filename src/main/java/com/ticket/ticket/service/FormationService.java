package com.ticket.ticket.service;

import com.ticket.ticket.model.Formation;
import com.ticket.ticket.repositorie.FormationRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormationService {

    // Injection de dependance
    private final FormationRepo formationRepo;

    public FormationService(FormationRepo formationRepo) {
        this.formationRepo = formationRepo;
    }

    //Ajout d'une formation
    public Formation ajoutFormation(Formation formation) {
        return formationRepo.save(formation);
    }

    //Affichage des formations
    public List<Formation> affichageFormations() {
        return formationRepo.findAll();
    }

    //Modification d'une formation
    public Formation modificationFormation(Long id, Formation formation) {
        // Cherche l'entité Formation par son ID
        Optional<Formation> formation1 = formationRepo.findById(id);
        if (formation1.isPresent()) {
            // Récupère l'entité existante
            Formation formationExistante = formation1.get();

            // Met à jour les champs souhaités
            formationExistante.setNom(formation.getNom());
            formationExistante.setDescription(formation.getDescription());
            formationExistante.setDuree(formation.getDuree());

            // Sauvegarde les modifications
            return formationRepo.save(formationExistante);
        } else {
            // Lance une exception si l'ID n'existe pas
            throw new EntityNotFoundException("Formation avec l'ID " + id + " n'existe pas.");
        }
    }


    //Suppression d'une formation
    public String suppressionFormation(Long id) {
        formationRepo.deleteById(id);
        return "La formation a été supprimé avec succès";
    }

}
