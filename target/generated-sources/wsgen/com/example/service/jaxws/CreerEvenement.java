
package com.example.service.jaxws;

import java.sql.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "creerEvenement", namespace = "http://service.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "creerEvenement", namespace = "http://service.example.com/", propOrder = {
    "nom",
    "lieu",
    "date",
    "description",
    "capaciteMax"
})
public class CreerEvenement {

    @XmlElement(name = "nom", namespace = "")
    private String nom;
    @XmlElement(name = "lieu", namespace = "")
    private String lieu;
    @XmlElement(name = "date", namespace = "")
    private Date date;
    @XmlElement(name = "description", namespace = "")
    private String description;
    @XmlElement(name = "capaciteMax", namespace = "")
    private int capaciteMax;

    /**
     * 
     * @return
     *     returns String
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * 
     * @param nom
     *     the value for the nom property
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getLieu() {
        return this.lieu;
    }

    /**
     * 
     * @param lieu
     *     the value for the lieu property
     */
    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    /**
     * 
     * @return
     *     returns Date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * 
     * @param date
     *     the value for the date property
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * 
     * @param description
     *     the value for the description property
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     returns int
     */
    public int getCapaciteMax() {
        return this.capaciteMax;
    }

    /**
     * 
     * @param capaciteMax
     *     the value for the capaciteMax property
     */
    public void setCapaciteMax(int capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

}
