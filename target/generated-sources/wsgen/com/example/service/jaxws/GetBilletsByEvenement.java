
package com.example.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getBilletsByEvenement", namespace = "http://service.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getBilletsByEvenement", namespace = "http://service.example.com/")
public class GetBilletsByEvenement {

    @XmlElement(name = "evenementId", namespace = "")
    private Long evenementId;

    /**
     * 
     * @return
     *     returns Long
     */
    public Long getEvenementId() {
        return this.evenementId;
    }

    /**
     * 
     * @param evenementId
     *     the value for the evenementId property
     */
    public void setEvenementId(Long evenementId) {
        this.evenementId = evenementId;
    }

}
