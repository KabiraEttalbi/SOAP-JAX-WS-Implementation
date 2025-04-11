
package com.example.service.jaxws;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "creerBilletsEnMasse", namespace = "http://service.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "creerBilletsEnMasse", namespace = "http://service.example.com/", propOrder = {
    "evenementId",
    "categorie",
    "prix",
    "nombreBillets"
})
public class CreerBilletsEnMasse {

    @XmlElement(name = "evenementId", namespace = "")
    private Long evenementId;
    @XmlElement(name = "categorie", namespace = "")
    private String categorie;
    @XmlElement(name = "prix", namespace = "")
    private BigDecimal prix;
    @XmlElement(name = "nombreBillets", namespace = "")
    private int nombreBillets;

    /**
     * 
     * @return
     *     returns Long
     */
    public Long getEvenementId() {
        return this.evenementId;
    }

    /**
     * 
     * @param evenementId
     *     the value for the evenementId property
     */
    public void setEvenementId(Long evenementId) {
        this.evenementId = evenementId;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getCategorie() {
        return this.categorie;
    }

    /**
     * 
     * @param categorie
     *     the value for the categorie property
     */
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    /**
     * 
     * @return
     *     returns BigDecimal
     */
    public BigDecimal getPrix() {
        return this.prix;
    }

    /**
     * 
     * @param prix
     *     the value for the prix property
     */
    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    /**
     * 
     * @return
     *     returns int
     */
    public int getNombreBillets() {
        return this.nombreBillets;
    }

    /**
     * 
     * @param nombreBillets
     *     the value for the nombreBillets property
     */
    public void setNombreBillets(int nombreBillets) {
        this.nombreBillets = nombreBillets;
    }

}
