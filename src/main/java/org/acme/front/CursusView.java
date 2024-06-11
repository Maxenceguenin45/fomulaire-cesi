package org.acme.front;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.inject.Inject;
import org.acme.model.Cursus;
import org.acme.model.Utilisateur;
import org.acme.service.CursusService;
import org.acme.service.UtilisateurService;

@Route("cursus")
@PageTitle("Créer Cursus")
public class CursusView extends VerticalLayout {

    @Inject
    private CursusService cursusService;

    @Inject
    private UtilisateurService utilisateurService;

    public CursusView() {
        BarMenu menu = new BarMenu();
        add(menu);
        IntegerField userIdField = new IntegerField("ID de l'utilisateur");
        TextField diplomeField = new TextField("Dernier diplôme");
        TextField etablissementField = new TextField("Établissement");
        TextField expProfessionnelleField = new TextField("Expérience professionnelle");
        TextField posteOccupeField = new TextField("Poste occupé");
        TextField dureeField = new TextField("Durée");

        Button saveButton = new Button("Enregistrer", event -> {
            Utilisateur utilisateur = utilisateurService.getUtilisateurById(userIdField.getValue());
            if (utilisateur != null) {
                Cursus cursus = new Cursus();
                cursus.setId_utilisateur(utilisateur);
                cursus.setDernier_diplome(diplomeField.getValue());
                cursus.setEtablissement(etablissementField.getValue());
                cursus.setExperience_professionnelle(expProfessionnelleField.getValue());
                cursus.setPoste_occupe(posteOccupeField.getValue());
                cursus.setDuree(dureeField.getValue());

                cursusService.createCursus(cursus);
                Notification.show("Cursus enregistré !");
            } else {
                Notification.show("Utilisateur non trouvé !");
            }
        });

        add(userIdField, diplomeField, etablissementField, expProfessionnelleField, posteOccupeField, dureeField, saveButton);
    }
}
