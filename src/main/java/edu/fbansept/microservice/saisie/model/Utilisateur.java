package edu.fbansept.microservice.saisie.model;

import com.fasterxml.jackson.annotation.JsonView;
import edu.fbansept.microservice.saisie.view.VueJson;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({VueJson.VueUtilisateur.class, VueJson.VuePays.class})
    private int id;

    @Column(nullable = false, unique = true)
    @JsonView({VueJson.VueUtilisateur.class, VueJson.VuePays.class})
    private String pseudo;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean actif;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }
}
