
package com.example.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.example.model.Billet;
import com.example.model.Utilisateur;

@XmlRootElement(name = "reserverBillet", namespace = "http://service.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reserverBillet", namespace = "http://service.example.com/", propOrder = {
    "utilisateur",
    "billet"
})
public class ReserverBillet {

    @XmlElement(name = "utilisateur", namespace = "")
    private Utilisateur utilisateur;
    @XmlElement(name = "billet", namespace = "")
    private Billet billet;

    /**
     * 
     * @return
     *     returns Utilisateur
     */
    public Utilisateur getUtilisateur() {
        return this.utilisateur;
    }

    /**
     * 
     * @param utilisateur
     *     the value for the utilisateur property
     */
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

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
