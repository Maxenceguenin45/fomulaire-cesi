package org.acme.front;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.RouterLink;
import jakarta.inject.Inject;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.acme.service.GreetService;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
public class MainView extends VerticalLayout {

    @Inject
    GreetService greetService;

    public MainView() {
        Tabs tabs = new Tabs();
        Tab tab1 = new Tab(new RouterLink("Main", MainView.class));
        Tab tab2 = new Tab(new RouterLink("Grid", UtilisateurView.class));
        //Tab tab3 = new Tab(new RouterLink("State", StateView.class));
        tabs.add(tab1, tab2);

        add(tabs);
    }
}


