package org.acme.service;

import jakarta.transaction.Transactional;
import org.acme.model.Domaine_Fomation;
import org.acme.model.Cursus;
import org.acme.model.Utilisateur;

import java.util.List;

public class DomaineService {
    private UtilisateurService utilisateurService;
    public List<Domaine_Fomation> listAll() {
        return Cursus.listAll();
    }
    @Transactional
    public Domaine_Fomation createCursus(Domaine_Fomation domaineFomation) {
        Domaine_Fomation newdomaineFomation = new Domaine_Fomation();
        newdomaineFomation.setDomaine(domaineFomation.getDomaine());
        newdomaineFomation.setType_bac(domaineFomation.getType_bac());
        newdomaineFomation.setId_utilisateur(domaineFomation.getId_utilisateur());
        newdomaineFomation.persist();
        return domaineFomation;
    }
    public Domaine_Fomation getDomaineByIdUtilisateur(int id) {
        Utilisateur utiliateur = utilisateurService.getUtilisateurById(id);
        return Domaine_Fomation.find("id_utilisateur", utiliateur).firstResult();
    }

}
