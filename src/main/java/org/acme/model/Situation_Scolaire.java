package org.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Situation_Scolaire extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
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
}
