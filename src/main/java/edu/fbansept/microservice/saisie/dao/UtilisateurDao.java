package edu.fbansept.microservice.saisie.dao;

import edu.fbansept.microservice.saisie.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurDao extends JpaRepository<Utilisateur,Integer> {
    Optional<Utilisateur> findByPseudo(String pseudo);
}
