
package com.example.service.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.example.model.Evenement;

@XmlRootElement(name = "getEvenementsResponse", namespace = "http://service.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getEvenementsResponse", namespace = "http://service.example.com/")
public class GetEvenementsResponse {

    @XmlElement(name = "evenements", namespace = "")
    private List<Evenement> evenements;

    /**
     * 
     * @return
     *     returns List&lt;Evenement&gt;
     */
    public List<Evenement> getEvenements() {
        return this.evenements;
    }

    /**
     * 
     * @param evenements
     *     the value for the evenements property
     */
    public void setEvenements(List<Evenement> evenements) {
        this.evenements = evenements;
    }

}
