package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.model.Situation_Scolaire;

import java.util.List;

@ApplicationScoped
public class CursusService {
    public List<Situation_Scolaire> listAll() {
        return Situation_Scolaire.listAll();
    }
    public Situation_Scolaire createCursus(Situation_Scolaire situationScolaire) {
        Situation_Scolaire createdSituationScolaire = new Situation_Scolaire();
        createdSituationScolaire.setDernier_diplome(situationScolaire.getDernier_diplome());
        createdSituationScolaire.setEtablissement(situationScolaire.getEtablissement());
        createdSituationScolaire.setExperience_professionnelle(situationScolaire.getExperience_professionnelle());
        createdSituationScolaire.setPoste_occupe(situationScolaire.getPoste_occupe());
        createdSituationScolaire.setDuree(situationScolaire.getDuree());
        createdSituationScolaire.persist();
     return createdSituationScolaire;
    }

}
