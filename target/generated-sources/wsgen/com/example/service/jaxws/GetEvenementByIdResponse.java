
package com.example.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.example.model.Evenement;

@XmlRootElement(name = "getEvenementByIdResponse", namespace = "http://service.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getEvenementByIdResponse", namespace = "http://service.example.com/")
public class GetEvenementByIdResponse {

    @XmlElement(name = "evenement", namespace = "")
    private Evenement evenement;

    /**
     * 
     * @return
     *     returns Evenement
     */
    public Evenement getEvenement() {
        return this.evenement;
    }

    /**
     * 
     * @param evenement
     *     the value for the evenement property
     */
    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

}
