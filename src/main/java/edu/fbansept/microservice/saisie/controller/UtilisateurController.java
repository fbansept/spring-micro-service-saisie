package edu.fbansept.microservice.saisie.controller;

import com.fasterxml.jackson.annotation.JsonView;
import edu.fbansept.microservice.saisie.dao.UtilisateurDao;
import edu.fbansept.microservice.saisie.model.Utilisateur;
import edu.fbansept.microservice.saisie.view.VueJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UtilisateurController {

    private UtilisateurDao utilisateurDao;

    @Autowired
    public UtilisateurController(
            UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }


    @GetMapping("/user/utilisateurs")
    @JsonView(VueJson.VueUtilisateur.class)
    public ResponseEntity<List<Utilisateur>> getListeUtilisateur() throws Exception {
        return ResponseEntity.ok(utilisateurDao.findAll());
    }

    @GetMapping("/user/utilisateur-by-pseudo/{pseudo}")
    @JsonView(VueJson.VueUtilisateur.class)
    public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable String pseudo) throws Exception {

        Optional<Utilisateur> utilisateur = utilisateurDao.findByPseudo(pseudo);

        if(utilisateur.isPresent()) {
            return ResponseEntity.ok(utilisateur.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/user/utilisateur/{id}")
    @JsonView(VueJson.VueUtilisateur.class)
    public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable int id) throws Exception {

        Optional<Utilisateur> utilisateur = utilisateurDao.findById(id);

        if(utilisateur.isPresent()) {
            return ResponseEntity.ok(utilisateur.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/user/utilisateur")
    public ResponseEntity<Integer> saveUtilisateur(@RequestBody Utilisateur utilisateur){
        utilisateur = utilisateurDao.saveAndFlush(utilisateur);
        return ResponseEntity.created(URI.create("/user/utilisateur/" + utilisateur.getId())).build();
    }
}
