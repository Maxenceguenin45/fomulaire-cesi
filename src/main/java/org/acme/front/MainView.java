package org.acme.front;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.inject.Inject;
import org.acme.model.Utilisateur;
import org.acme.service.UtilisateurService;

@Route("")
public class MainView extends VerticalLayout {

    @Inject
    UtilisateurService utilisateurService;

    public MainView() {

        BarMenu menu = new BarMenu();
        add(menu);

        FormLayout formLayout = new FormLayout();
        Utilisateur utilisateur = new Utilisateur();

        TextField nom = new TextField("Nom");
        nom.setPlaceholder("Marie");

        TextField prenom = new TextField("Prenom");
        prenom.setPlaceholder("Pen");

        DatePicker date_naissance = new DatePicker("Date de naissance");

        TextField adresse = new TextField("Adresse");
        adresse.setPlaceholder("123 rue de Exemple");

        NumberField telephone = new NumberField("Telephone");
        telephone.setPlaceholder("0601020304");

        EmailField email = new EmailField("Email");
        email.setPlaceholder("exemple@domaine.com");

        NumberField code_postal = new NumberField("Code postal");
        code_postal.setPlaceholder("75000");

        formLayout.add(nom, prenom, date_naissance, adresse, telephone, email, code_postal);
        add(formLayout);

        Button button = new Button("Enregistrer",
                e -> {
                    utilisateur.setNom(nom.getValue());
                    utilisateur.setPrenom(prenom.getValue());
                    utilisateur.setDate_naissance(date_naissance.getValue() != null ? date_naissance.getValue().atStartOfDay() : null);
                    utilisateur.setAdresse(adresse.getValue());
                    utilisateur.setTelephone(telephone.getValue() != null ? telephone.getValue().toString() : "");
                    utilisateur.setEmail(email.getValue());
                    utilisateur.setCode_postal(code_postal.getValue() != null ? code_postal.getValue().toString() : "");
                    utilisateurService.addUtilisateur(utilisateur);
                    Notification.show("Utilisateur enregistré avec succès !");
                });

        add(button);
        setAlignItems(Alignment.CENTER);
        formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0", 1));
    }
}
