package com.example.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@XmlRootElement(name = "reservation")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "reservations")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(required = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    @XmlElement(required = true)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "billet_id")
    @XmlElement(required = true)
    private Billet billet;

    @XmlElement(required = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReservation;

    @XmlElement(required = true)
    private String statut;

    public Reservation() {
    }

    public Reservation(Utilisateur utilisateur, Billet billet, Date dateReservation, String statut) {
        this.utilisateur = utilisateur;
        this.billet = billet;
        this.dateReservation = dateReservation;
        this.statut = statut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Billet getBillet() {
        return billet;
    }

    public void setBillet(Billet billet) {
        this.billet = billet;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
}
