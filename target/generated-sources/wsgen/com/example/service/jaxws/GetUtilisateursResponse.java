
package com.example.service.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.example.model.Utilisateur;

@XmlRootElement(name = "getUtilisateursResponse", namespace = "http://service.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUtilisateursResponse", namespace = "http://service.example.com/")
public class GetUtilisateursResponse {

    @XmlElement(name = "utilisateurs", namespace = "")
    private List<Utilisateur> utilisateurs;

    /**
     * 
     * @return
     *     returns List&lt;Utilisateur&gt;
     */
    public List<Utilisateur> getUtilisateurs() {
        return this.utilisateurs;
    }

    /**
     * 
     * @param utilisateurs
     *     the value for the utilisateurs property
     */
    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

}
