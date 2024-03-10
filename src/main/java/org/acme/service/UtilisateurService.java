package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.model.Utilisateur;

import java.util.List;
@ApplicationScoped
public class UtilisateurService {
    public List<Utilisateur> listAll() {
        return Utilisateur.listAll();
    }

}
