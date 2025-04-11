
package com.example.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "modifierReservation", namespace = "http://service.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifierReservation", namespace = "http://service.example.com/", propOrder = {
    "id",
    "statut"
})
public class ModifierReservation {

    @XmlElement(name = "id", namespace = "")
    private Long id;
    @XmlElement(name = "statut", namespace = "")
    private String statut;

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
    public String getStatut() {
        return this.statut;
    }

    /**
     * 
     * @param statut
     *     the value for the statut property
     */
    public void setStatut(String statut) {
        this.statut = statut;
    }

}
