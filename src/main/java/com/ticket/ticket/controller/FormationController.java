package com.ticket.ticket.controller;

import com.ticket.ticket.model.Formation;
import com.ticket.ticket.service.FormationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formation")
@AllArgsConstructor
public class FormationController {

    private final FormationService formationService;

    @PostMapping("/ajout")
    public Formation ajout(@RequestBody Formation formation) {
        return formationService.ajoutFormation(formation);
    }

    @GetMapping("/liste")
    public List<Formation> lister() {
        return formationService.affichageFormations();
    }

    @PutMapping("/update/{id}")
    public Formation update(@PathVariable Long id, @RequestBody Formation formation) {
        return formationService.modificationFormation(id,formation);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return formationService.suppressionFormation(id);
    }
}
