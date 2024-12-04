package com.ticket.ticket.service;

import com.ticket.ticket.model.Reponse;
import com.ticket.ticket.repositorie.ReponseRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReponseService {

    //injection de dependance
    private final ReponseRepo reponseRepo;

    public ReponseService(ReponseRepo reponseRepo) {
        this.reponseRepo = reponseRepo;
    }

    //les methodes CRUD

    public Reponse ajoutReponse(Reponse reponse) {
        return reponseRepo.save(reponse);
    }

    public List<Reponse> affichageReponses() {
        return reponseRepo.findAll();
    }

    public Reponse modificationReponse(Long id, Reponse reponse) {
        Optional<Reponse> reponse1 = reponseRepo.findById(id);
        if(reponse1.isPresent()) {
            Reponse reponseExistante = reponse1.get();
            reponseExistante.setContenu(reponse.getContenu());
            return reponseRepo.save(reponseExistante);
        } else {
            // Lance une exception si l'ID n'existe pas
            throw new EntityNotFoundException("La reponse avec l'ID " + id + " n'existe pas."); }
    }

    public String suppressionMessage(Long id) {
        reponseRepo.deleteById(id);
        return "Reponse supprimé avec succès";
    }
}
