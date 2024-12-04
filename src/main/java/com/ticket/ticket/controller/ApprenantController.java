package com.ticket.ticket.controller;

import com.ticket.ticket.model.Apprenant;
import com.ticket.ticket.model.Formation;
import com.ticket.ticket.service.ApprenantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apprenant")
@RequiredArgsConstructor
public class ApprenantController {

    private final ApprenantService apprenantService;

    @PostMapping("/ajout")
    public Apprenant ajout(@RequestBody Apprenant apprenant) {
        return apprenantService.ajoutApprenant(apprenant);
    }

    @GetMapping("/liste")
    public List<Apprenant> lister() {
        return apprenantService.affichageApprenant();
    }

    @PutMapping("/update/{id}")
    public Apprenant update(@PathVariable Long id, @RequestBody Apprenant apprenant) {
        return apprenantService.modificationApprenant(id,apprenant);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return apprenantService.suppressionApprenant(id);
    }
}
