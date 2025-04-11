package com.example.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@XmlRootElement(name = "evenement")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "evenements")
public class Evenement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(required = true)
    private Long id;

    @XmlElement(required = true)
    private String nom;

    @XmlElement(required = true)
    private String lieu;

    @XmlElement(required = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @XmlElement(required = true)
    private String description;

    @XmlElement(required = true)
    private int capaciteMax;

    public Evenement() {
    }

    public Evenement(String nom, String lieu, Date date, String description, int capaciteMax) {
        this.nom = nom;
        this.lieu = lieu;
        this.date = date;
        this.description = description;
        this.capaciteMax = capaciteMax;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapaciteMax() {
        return capaciteMax;
    }

    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }
}
