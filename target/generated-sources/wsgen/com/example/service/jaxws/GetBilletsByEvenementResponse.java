
package com.example.service.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.example.model.Billet;

@XmlRootElement(name = "getBilletsByEvenementResponse", namespace = "http://service.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getBilletsByEvenementResponse", namespace = "http://service.example.com/")
public class GetBilletsByEvenementResponse {

    @XmlElement(name = "billets", namespace = "")
    private List<Billet> billets;

    /**
     * 
     * @return
     *     returns List&lt;Billet&gt;
     */
    public List<Billet> getBillets() {
        return this.billets;
    }

    /**
     * 
     * @param billets
     *     the value for the billets property
     */
    public void setBillets(List<Billet> billets) {
        this.billets = billets;
    }

}
