package com.example.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;

@XmlRootElement(name = "billet")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "billets")
public class Billet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(required = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evenement_id")
    @XmlElement(required = true)
    private Evenement evenement;

    @XmlElement(required = true)
    private String categorie;

    @XmlElement(required = true)
    private BigDecimal prix;

    @XmlElement(required = true)
    private boolean disponible;

    public Billet() {
    }

    public Billet(Evenement evenement, String categorie, BigDecimal prix, boolean disponible) {
        this.evenement = evenement;
        this.categorie = categorie;
        this.prix = prix;
        this.disponible = disponible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
