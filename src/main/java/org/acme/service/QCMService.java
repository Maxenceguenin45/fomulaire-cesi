package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.acme.model.QCM;
import org.acme.model.Utilisateur;
import org.acme.service.UtilisateurService;
import java.util.List;

@ApplicationScoped
public class QCMService {
    private UtilisateurService utilisateurService = new UtilisateurService();
    public List<QCM> listAll() {
        return QCM.listAll();
    }
    @Transactional
    public QCM createQCM(QCM qcm) {
        QCM createdQCM = new QCM();
        createdQCM.setOrientation_formation(qcm.getOrientation_formation());
        createdQCM.setPret(qcm.getPret());
        createdQCM.setMission_international(qcm.getMission_international());
        createdQCM.setVia_associative(qcm.getVia_associative());
        createdQCM.setProjet_associative(qcm.getProjet_associative());
        createdQCM.setMatiere_generale(qcm.getMatiere_generale());
        createdQCM.setTotal(qcm.getTotal());
        createdQCM.persist();
        return createdQCM;
    }
    public QCM getQCMByIdUtilisateur(int id) {
        Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
        return QCM.find("id_utilisateur", utilisateur).firstResult();
    }
}
