package org.acme.front;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
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
import org.acme.service.CursusService;
import org.acme.service.UtilisateurService;

@Route("utilisateur")
public class GrilUsagerNonValiderView extends VerticalLayout {

    @Inject
    UtilisateurService utilisateurService;

    @Inject
    CursusService cursusService;

    public GrilUsagerNonValiderView() {

        setSizeFull();
        setPadding(false);

        BarMenu menu = new BarMenu();
        add(menu);

        Grid<Utilisateur> grid = new Grid<>();
        grid.setSizeFull();
        grid.setItems(Utilisateur.listAll());

        grid.addColumn(Utilisateur::getNom).setHeader("Nom").setSortable(true);
        grid.addColumn(Utilisateur::getPrenom).setHeader("Prenom").setSortable(true);
        grid.addColumn(Utilisateur::getEmail).setHeader("Email").setSortable(true);
        grid.addComponentColumn(utilisateur -> {
            Button detailButton = new Button("Détails Cursus", clickEvent -> {
                Cursus cursus = this.cursusService.getCursusByIdUtilisateur(utilisateur.getId());
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
            String dernierDiplome = cursus.getDernier_diplome() != null ? cursus.getDernier_diplome() : "Non renseigné";
            String etablissement = cursus.getEtablissement() != null ? cursus.getEtablissement() : "Non renseigné";

            Div diplomeDiv = new Div(new Text("Dernier diplôme : " + dernierDiplome));
            Div etablissementDiv = new Div(new Text("Établissement : " + etablissement));

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

        dialog.open();
    }
}
