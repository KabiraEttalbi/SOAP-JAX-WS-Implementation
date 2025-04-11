
package com.example.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.example.model.Utilisateur;

@XmlRootElement(name = "connecterUtilisateurResponse", namespace = "http://service.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "connecterUtilisateurResponse", namespace = "http://service.example.com/")
public class ConnecterUtilisateurResponse {

    @XmlElement(name = "utilisateur", namespace = "")
    private Utilisateur utilisateur;

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

}
