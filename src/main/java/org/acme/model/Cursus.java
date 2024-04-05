package org.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
public class Cursus extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int id;
    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur id_utilisateur;
    private String dernier_diplome;
    private String etablissement;
    private String experience_professionnelle;
    private String poste_occupe;
    private String duree;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Utilisateur getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Utilisateur id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getDernier_diplome() {
        return dernier_diplome;
    }

    public void setDernier_diplome(String dernier_diplome) {
        this.dernier_diplome = dernier_diplome;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public String getExperience_professionnelle() {
        return experience_professionnelle;
    }

    public void setExperience_professionnelle(String experience_professionnelle) {
        this.experience_professionnelle = experience_professionnelle;
    }

    public String getPoste_occupe() {
        return poste_occupe;
    }

    public void setPoste_occupe(String poste_occupe) {
        this.poste_occupe = poste_occupe;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public static Cursus findByUtilisateurId(int id_utilisateur) {
        return find("id_utilisateur", id_utilisateur).firstResult();
    }
}
