package org.acme.front;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import org.acme.model.Cursus;
import org.acme.service.CursusService;

@Route("cursus-list")
public class CursusListView extends VerticalLayout {
    @Inject
    private CursusService cursusService;

    private Grid<Cursus> grid = new Grid<>(Cursus.class);

    public CursusListView() {
        add(grid);
    }

    @PostConstruct
    private void init() {
        grid.setColumns("dernier_diplome", "etablissement", "experience_professionnelle", "poste_occupe", "duree");
        grid.setItems(cursusService.listAll());

        grid.addComponentColumn(cursus -> new Button("Détails", click -> showCursusDetailsDialog(cursus)))
                .setHeader("Actions");
    }
    private void showCursusDetailsDialog(Cursus cursus) {
        Dialog dialog = new Dialog();
        dialog.add(new Div(new Text("Dernier diplôme: " + cursus.getDernier_diplome())));
        dialog.add(new Div(new Text("Établissement: " + cursus.getEtablissement())));
        dialog.add(new Div(new Text("Expérience professionnelle: " + cursus.getExperience_professionnelle())));
        dialog.add(new Div(new Text("Poste occupé: " + cursus.getPoste_occupe())));
        dialog.add(new Div(new Text("Durée: " + cursus.getDuree())));

        Button closeButton = new Button("Fermer", e -> dialog.close());
        dialog.add(closeButton);

        dialog.open();
    }
}
