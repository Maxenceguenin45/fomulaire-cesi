package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.model.Cursus;
import org.acme.model.Utilisateur;

import java.util.List;

@ApplicationScoped
public class CursusService {
    private UtilisateurService utilisateurService;
    public List<Cursus> listAll() {
        return Cursus.listAll();
    }
    @Transactional
    public Cursus createCursus(Cursus situationScolaire) {
        Cursus createdSituationScolaire = new Cursus();
        createdSituationScolaire.setDernier_diplome(situationScolaire.getDernier_diplome());
        createdSituationScolaire.setEtablissement(situationScolaire.getEtablissement());
        createdSituationScolaire.setExperience_professionnelle(situationScolaire.getExperience_professionnelle());
        createdSituationScolaire.setPoste_occupe(situationScolaire.getPoste_occupe());
        createdSituationScolaire.setDuree(situationScolaire.getDuree());
        createdSituationScolaire.persist();
     return createdSituationScolaire;
    }
    public Cursus getSituationScolaireByIdUtilisateur(int id) {
       Utilisateur utiliateur = utilisateurService.getUtilisateurById(id);
       return Cursus.find("id_utilisateur", utiliateur).firstResult();
    }
}