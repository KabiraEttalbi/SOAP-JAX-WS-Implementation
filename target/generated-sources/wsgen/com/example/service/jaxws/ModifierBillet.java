
package com.example.service.jaxws;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "modifierBillet", namespace = "http://service.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifierBillet", namespace = "http://service.example.com/", propOrder = {
    "id",
    "categorie",
    "prix",
    "disponible"
})
public class ModifierBillet {

    @XmlElement(name = "id", namespace = "")
    private Long id;
    @XmlElement(name = "categorie", namespace = "")
    private String categorie;
    @XmlElement(name = "prix", namespace = "")
    private BigDecimal prix;
    @XmlElement(name = "disponible", namespace = "")
    private boolean disponible;

    /**
     * 
     * @return
     *     returns Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * 
     * @param id
     *     the value for the id property
     */
    public void setId(Long id) {
        this.id = id;
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
     *     returns boolean
     */
    public boolean isDisponible() {
        return this.disponible;
    }

    /**
     * 
     * @param disponible
     *     the value for the disponible property
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

}
