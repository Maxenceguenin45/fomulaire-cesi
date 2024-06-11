package org.acme.front;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class BarMenu extends VerticalLayout {

    public BarMenu() {
        HorizontalLayout topBar = new HorizontalLayout();
        topBar.setWidthFull();
        topBar.setPadding(true);
        topBar.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        Image logo = new Image("./images/logo.png", "Logo");
        logo.setHeight("100px");
        topBar.add(logo);

        Button mainButton = new Button("Main", e -> UI.getCurrent().navigate(MainView.class));
        Button utilisateursButton = new Button("Utilisateurs", e -> UI.getCurrent().navigate(GrilUsagerNonValiderView.class));
        Button cursusButton = new Button("Cursus", e -> UI.getCurrent().navigate(CursusView.class));
        Button listButton = new Button("List", e -> UI.getCurrent().navigate(CursusListView.class));

        topBar.add(mainButton, utilisateursButton, cursusButton, listButton);

        add(topBar);
    }
}
