
package com.example.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "creerBilletsEnMasseResponse", namespace = "http://service.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "creerBilletsEnMasseResponse", namespace = "http://service.example.com/")
public class CreerBilletsEnMasseResponse {

    @XmlElement(name = "nombreBilletsCrees", namespace = "")
    private int nombreBilletsCrees;

    /**
     * 
     * @return
     *     returns int
     */
    public int getNombreBilletsCrees() {
        return this.nombreBilletsCrees;
    }

    /**
     * 
     * @param nombreBilletsCrees
     *     the value for the nombreBilletsCrees property
     */
    public void setNombreBilletsCrees(int nombreBilletsCrees) {
        this.nombreBilletsCrees = nombreBilletsCrees;
    }

}
