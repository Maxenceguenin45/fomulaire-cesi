package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Cursus;
import org.acme.model.Utilisateur;

import java.util.List;

@ApplicationScoped
public class CursusService {
    public List<Cursus> listAll() {
        return Cursus.listAll();
    }
    public Cursus createCursus(Cursus cursus) {
        Cursus createdCursus = new Cursus();
        createdCursus.setDernier_diplome(cursus.getDernier_diplome());
        createdCursus.setEtablissement(cursus.getEtablissement());
        createdCursus.setExperience_professionnelle(cursus.getExperience_professionnelle());
        createdCursus.setPoste_occupe(cursus.getPoste_occupe());
        createdCursus.setDuree(cursus.getDuree());
        createdCursus.persist();
     return createdCursus;
    }

}
