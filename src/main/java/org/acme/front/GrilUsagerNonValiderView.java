package org.acme.front;

import com.vaadin.flow.component.grid.Grid;
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
            //Tab tab3 = new Tab(new RouterLink("State", StateView.class));
            tabs.add(tab1, tab2);
            tabs.setSelectedTab(tab2);

            add(tabs);
            Grid<Utilisateur> grid = new Grid<>();
            grid.setItems(Utilisateur.listAll());
            grid.addColumn(Utilisateur::getId).setHeader("ID");
            grid.addColumn(Utilisateur::getNom).setHeader("Nom");
            grid.addColumn(Utilisateur::getPrenom).setHeader("Prenom");
            grid.addColumn(Utilisateur::getEmail).setHeader("Email");
            grid.addColumn(Utilisateur::getTelephone).setHeader("Tel");
            grid.addColumn(Utilisateur::getDate_naissance).setHeader("Date de naissance");
            grid.addColumn(Utilisateur::getAdresse).setHeader("Adresse");
            grid.addColumn(Utilisateur::getCode_postal).setHeader("Code postal");
            add(grid);
        }

}
