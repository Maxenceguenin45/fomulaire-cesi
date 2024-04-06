package org.acme.service;
import jakarta.transaction.Transactional;
import org.acme.model.Connaisances_Evenement;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ConnaissanceServise {
    @Transactional
    public Connaisances_Evenement createConnaissance(Connaisances_Evenement connaissance) {
        Connaisances_Evenement newConnaissance = new Connaisances_Evenement();
        newConnaissance.setReseau(connaissance.getReseau());
        newConnaissance.persist();
        return newConnaissance;
    }
    public Connaisances_Evenement getConnaissanceByIdUtilisateur(int id) {
        return Connaisances_Evenement.find("id_utilisateur", id).firstResult();
    }
    public List<Connaisances_Evenement> listAll() {
        return Connaisances_Evenement.listAll();
    }
}
