
package com.example.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getNombreReservationsParEvenementResponse", namespace = "http://service.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getNombreReservationsParEvenementResponse", namespace = "http://service.example.com/")
public class GetNombreReservationsParEvenementResponse {

    @XmlElement(name = "nombreReservations", namespace = "")
    private int nombreReservations;

    /**
     * 
     * @return
     *     returns int
     */
    public int getNombreReservations() {
        return this.nombreReservations;
    }

    /**
     * 
     * @param nombreReservations
     *     the value for the nombreReservations property
     */
    public void setNombreReservations(int nombreReservations) {
        this.nombreReservations = nombreReservations;
    }

}
