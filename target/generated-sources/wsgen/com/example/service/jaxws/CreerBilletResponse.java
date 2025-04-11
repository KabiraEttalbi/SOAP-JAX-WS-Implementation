
package com.example.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.example.model.Billet;

@XmlRootElement(name = "creerBilletResponse", namespace = "http://service.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "creerBilletResponse", namespace = "http://service.example.com/")
public class CreerBilletResponse {

    @XmlElement(name = "billet", namespace = "")
    private Billet billet;

    /**
     * 
     * @return
     *     returns Billet
     */
    public Billet getBillet() {
        return this.billet;
    }

    /**
     * 
     * @param billet
     *     the value for the billet property
     */
    public void setBillet(Billet billet) {
        this.billet = billet;
    }

}
