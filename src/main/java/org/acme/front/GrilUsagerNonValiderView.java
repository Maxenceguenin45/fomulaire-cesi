package org.acme.front;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.acme.model.Utilisateur;

@Route("utilisateur")
public class GrilUsagerNonValiderView extends VerticalLayout {
    public GrilUsagerNonValiderView() {
        Tabs tabs = new Tabs();
        Tab tab1 = new Tab(new RouterLink("Main", MainView.class));
        Tab tab2 = new Tab(new RouterLink("Usager", GrilUsagerNonValiderView.class));
        tabs.add(tab1, tab2);
        tabs.setSelectedTab(tab2);
        add(tabs);

        Grid<Utilisateur> grid = new Grid<>();
        grid.setItems(Utilisateur.listAll());

        grid.addColumn(Utilisateur::getNom).setHeader("Nom").setSortable(true);
        grid.addColumn(Utilisateur::getPrenom).setHeader("Prenom").setSortable(true);
        grid.addColumn(Utilisateur::getEmail).setHeader("Email").setSortable(true);
        grid.addColumn(user -> "À définir").setHeader("Cursus").setSortable(true);

        grid.addComponentColumn(user -> {
            Button detailButton = new Button("Détails", event -> showUserDetailsDialog(user));
            return detailButton;
        }).setHeader("Actions");

        add(grid);
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
