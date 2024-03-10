package org.acme.controller;

import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.model.Utilisateur;
import org.acme.service.UtilisateurService;

import java.util.List;

@Path("/utilisateur")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped

public class ControllerUtilisateur {
    @Inject
    UtilisateurService utilisateurService;
    @GET
    @PermitAll
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurService.listAll();
    }

}
