package org.acme.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class QCM extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private Utilisateur id_utilisateur;
    private String orientation_formation;
    private String pret;
    private String mission_international;
    private String via_associative;
    private String projet_associative;
    private String matiere_generale;
    private String total;

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

    public String getOrientation_formation() {
        return orientation_formation;
    }

    public void setOrientation_formation(String orientation_formation) {
        this.orientation_formation = orientation_formation;
    }

    public String getPret() {
        return pret;
    }

    public void setPret(String pret) {
        this.pret = pret;
    }

    public String getMission_international() {
        return mission_international;
    }

    public void setMission_international(String mission_international) {
        this.mission_international = mission_international;
    }

    public String getVia_associative() {
        return via_associative;
    }

    public void setVia_associative(String via_associative) {
        this.via_associative = via_associative;
    }

    public String getProjet_associative() {
        return projet_associative;
    }

    public void setProjet_associative(String projet_associative) {
        this.projet_associative = projet_associative;
    }

    public String getMatiere_generale() {
        return matiere_generale;
    }

    public void setMatiere_generale(String matiere_generale) {
        this.matiere_generale = matiere_generale;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
