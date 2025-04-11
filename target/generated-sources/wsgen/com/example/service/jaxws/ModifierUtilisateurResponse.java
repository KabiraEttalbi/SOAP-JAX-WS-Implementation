
package com.example.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "modifierUtilisateurResponse", namespace = "http://service.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "modifierUtilisateurResponse", namespace = "http://service.example.com/")
public class ModifierUtilisateurResponse {

    @XmlElement(name = "success", namespace = "")
    private boolean success;

    /**
     * 
     * @return
     *     returns boolean
     */
    public boolean isSuccess() {
        return this.success;
    }

    /**
     * 
     * @param success
     *     the value for the success property
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

}
