package org.acme.front;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import jakarta.inject.Inject;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.acme.model.Utilisateur;
import org.acme.service.UtilisateurService;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
public class MainView extends VerticalLayout {

    @Inject
    UtilisateurService utilisateurService;

    public MainView() {

        VerticalLayout layout = new VerticalLayout();
        Utilisateur utilisateur = new Utilisateur();

        TextField nom = new TextField("Nom");
        TextField prenom = new TextField("Prenom");
        DatePicker date_naissance = new DatePicker("Date de naissance");
        TextField adresse = new TextField("Adresse");
        NumberField telephone = new NumberField("Telephone");
        EmailField email = new EmailField("Email");
        NumberField code_postal = new NumberField("Code postal");

        layout.add(nom, prenom, date_naissance, adresse, telephone, email, code_postal);
        add(layout);

        Button button = new Button("Click me",
                e -> {
                    utilisateur.setNom(nom.getValue());
                    utilisateur.setPrenom(prenom.getValue());
                    utilisateur.setDate_naissance(date_naissance.getValue().atStartOfDay());
                    utilisateur.setAdresse(adresse.getValue());
                    utilisateur.setTelephone(telephone.getValue().toString());
                    utilisateur.setEmail(email.getValue());
                    utilisateur.setCode_postal(code_postal.getValue().toString());
                    utilisateurService.addUtilisateur(utilisateur);
                });
        add(button);

    }
}


