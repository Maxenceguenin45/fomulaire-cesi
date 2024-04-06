package org.acme.front;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import jakarta.inject.Inject;
import org.acme.model.Cursus;
import org.acme.model.Utilisateur;
import org.acme.service.UtilisateurService;

@Route("utilisateur")
public class GrilUsagerNonValiderView extends VerticalLayout {

    @Inject
    UtilisateurService utilisateurService;

    public GrilUsagerNonValiderView() {
        HorizontalLayout topBar = new HorizontalLayout();
        topBar.setWidthFull();
        topBar.setPadding(true);
        topBar.getStyle().set("background-color", "#f8f9fa");

        Image logo = new Image("./META-INF/resources/images/logo.png", "Logo");
        //logo.setHeight("50px");

        topBar.add(logo);

        topBar.setDefaultVerticalComponentAlignment(Alignment.CENTER);

        add(topBar);

        Tabs tabs = new Tabs();
        Tab tab1 = new Tab(new RouterLink("Main", MainView.class));
        Tab tab2 = new Tab(new RouterLink("Utilisateurs", GrilUsagerNonValiderView.class));
        Tab tab3 = new Tab(new RouterLink("Cursus", CursusView.class));
        Tab tab4 = new Tab(new RouterLink("List", CursusListView.class));
        tabs.add(tab1, tab2, tab3, tab4);
        tabs.setSelectedTab(tab2);
        add(tabs);
        topBar.add(tabs);

        Grid<Utilisateur> grid = new Grid<>();
        grid.setItems(Utilisateur.listAll());

        grid.addColumn(Utilisateur::getNom).setHeader("Nom").setSortable(true);
        grid.addColumn(Utilisateur::getPrenom).setHeader("Prenom").setSortable(true);
        grid.addColumn(Utilisateur::getEmail).setHeader("Email").setSortable(true);
        grid.addComponentColumn(utilisateur -> {
            Button detailButton = new Button("Détails Cursus", clickEvent -> {
                Cursus cursus = Cursus.findByUtilisateurId(utilisateur.getId());
                showCursusDetailsDialog(cursus);
            });

            return detailButton;
        }).setHeader("Détails Cursus");

        grid.addComponentColumn(user -> {
            Button detailButton = new Button("Détails", event -> showUserDetailsDialog(user));
            return detailButton;
        }).setHeader("Actions");

        add(grid);
    }

    private void showCursusDetailsDialog(Cursus cursus) {
        Dialog dialog = new Dialog();
        if (cursus != null) {
            Div diplomeDiv = new Div(new Text("Dernier diplôme : " + cursus.getDernier_diplome()));
            Div etablissementDiv = new Div(new Text("Établissement : " + cursus.getEtablissement()));
            dialog.add(diplomeDiv, etablissementDiv);
        } else {
            dialog.add(new Text("Aucun cursus trouvé pour cet utilisateur."));
        }
        dialog.open();
    }

    private void showUserDetailsDialog(Utilisateur user) {
        Dialog dialog = new Dialog();

        dialog.add(new Div(new Text("Nom : " + user.getNom())));
        dialog.add(new Div(new Text("Prenom : " + user.getPrenom())));
        dialog.add(new Div(new Text("Email : " + user.getEmail())));
        dialog.add(new Div(new Text("Tel : " + user.getTelephone())));
        dialog.add(new Div(new Text("Date de naissance : " + user.getDate_naissance())));
        dialog.add(new Div(new Text("Adresse : " + user.getAdresse())));
        dialog.add(new Div(new Text("Code postal : " + user.getCode_postal())));
       /* if (cursus != null) {
            // Créer un bouton pour afficher les détails du cursus
            Button showCursusDetails = new Button("Afficher détails du cursus", event -> {
                Dialog cursusDialog = new Dialog();
                cursusDialog.add(new Div(new Text("Dernier diplôme : " + cursus.getDernier_diplome())));
                cursusDialog.add(new Div(new Text("Etablissement : " + cursus.getEtablissement())));
                cursusDialog.add(new Div(new Text("Expérience professionnelle : " + cursus.getExperience_professionnelle())));
                cursusDialog.add(new Div(new Text("Poste occupé : " + cursus.getPoste_occupe())));
                cursusDialog.add(new Div(new Text("Durée : " + cursus.getDuree())));
                cursusDialog.open();
            });
            dialog.add(showCursusDetails);
        } else {
            dialog.add(new Div(new Text("Cursus : Non défini")));
        }
*/

        dialog.open();
    }
}
