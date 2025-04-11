
package com.example.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "inscrireUtilisateur", namespace = "http://service.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inscrireUtilisateur", namespace = "http://service.example.com/", propOrder = {
    "nom",
    "email",
    "motDePasse"
})
public class InscrireUtilisateur {

    @XmlElement(name = "nom", namespace = "")
    private String nom;
    @XmlElement(name = "email", namespace = "")
    private String email;
    @XmlElement(name = "motDePasse", namespace = "")
    private String motDePasse;

    /**
     * 
     * @return
     *     returns String
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * 
     * @param nom
     *     the value for the nom property
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

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
