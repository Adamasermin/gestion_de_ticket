package com.ticket.ticket.controller;

import com.ticket.ticket.model.Formateur;
import com.ticket.ticket.model.Formation;
import com.ticket.ticket.service.FormateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formateur")
@RequiredArgsConstructor
public class FormateurController {

    private final FormateurService formateurService;

    @PostMapping("/ajout")
    public Formateur ajout(@RequestBody Formateur formateur) {
        return formateurService.ajoutFormateur(formateur);
    }

    @GetMapping("/liste")
    public List<Formateur> lister() {
        return formateurService.affichageFormateur();
    }

    @PutMapping("/update/{id}")
    public Formateur update(@PathVariable Long id, @RequestBody Formateur formateur) {
        return formateurService.modificationFormateur(id,formateur);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return formateurService.suppressionFormateur(id);
    }
}
