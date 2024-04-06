package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.model.cesi;

@ApplicationScoped
public class CesiService {
    @Transactional
    public void createCesi(cesi cesi) {
        cesi newCesi = new cesi();
        newCesi.setAvec(cesi.getAvec());
        newCesi.setFormation(cesi.getFormation());
        newCesi.setDateRDV(cesi.getDateRDV());
        newCesi.setId_utilisateur(cesi.getId_utilisateur());
        newCesi.setRDVImmersion(cesi.getRDVImmersion());
        newCesi.setPresentiel(cesi.isPresentiel());
        newCesi.setStatut(cesi.getStatut());
    }
    public cesi getCesiByIdUtilisateur(int id) {
        return cesi.find("id_utilisateur", id).firstResult();
    }
}
