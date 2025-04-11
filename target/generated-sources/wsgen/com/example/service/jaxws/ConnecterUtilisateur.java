
package com.example.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "connecterUtilisateur", namespace = "http://service.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "connecterUtilisateur", namespace = "http://service.example.com/", propOrder = {
    "email",
    "motDePasse"
})
public class ConnecterUtilisateur {

    @XmlElement(name = "email", namespace = "")
    private String email;
    @XmlElement(name = "motDePasse", namespace = "")
    private String motDePasse;

    /**
     * 
     * @return
     *     returns String
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * 
     * @param email
     *     the value for the email property
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getMotDePasse() {
        return this.motDePasse;
    }

    /**
     * 
     * @param motDePasse
     *     the value for the motDePasse property
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

}
