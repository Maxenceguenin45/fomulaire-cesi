package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.model.Utilisateur;

import java.util.List;

@ApplicationScoped
public class UtilisateurService {

    public List<Utilisateur> listAll() {
        return Utilisateur.listAll();
    }

    @Transactional
    public Utilisateur addUtilisateur(Utilisateur reponseUtilisateur) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(reponseUtilisateur.getNom());
        utilisateur.setPrenom(reponseUtilisateur.getPrenom());
        utilisateur.setDate_naissance(reponseUtilisateur.getDate_naissance());
        utilisateur.setAdresse(reponseUtilisateur.getAdresse());
        utilisateur.setTelephone(reponseUtilisateur.getTelephone());
        utilisateur.setEmail(reponseUtilisateur.getEmail());
        utilisateur.setCode_postal(reponseUtilisateur.getCode_postal());
        utilisateur.persist();
        return utilisateur;
    }

    public Utilisateur getUtilisateurById(int id) {
        return Utilisateur.findById(id);
    }
}

