package com.ticket.ticket.controller;

import com.ticket.ticket.model.Reponse;
import com.ticket.ticket.service.ReponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Reponse")
@RequiredArgsConstructor
public class ReponseController {

    private final ReponseService reponseService;

    @PostMapping("/ajout")
    public Reponse ajout(@RequestBody Reponse reponse) {
        return reponseService.ajoutReponse(reponse);
    }

    @GetMapping("/liste")
    public List<Reponse> lister() {
        return reponseService.affichageReponses();
    }

    @PutMapping("/update/{id}")
    public Reponse update(@PathVariable Long id, @RequestBody Reponse reponse) {
        return reponseService.modificationReponse(id,reponse);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return reponseService.suppressionMessage(id);
    }
}
