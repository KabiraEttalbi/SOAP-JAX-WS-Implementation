
package com.example.service.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.example.model.Reservation;

@XmlRootElement(name = "reserverBilletResponse", namespace = "http://service.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reserverBilletResponse", namespace = "http://service.example.com/")
public class ReserverBilletResponse {

    @XmlElement(name = "reservation", namespace = "")
    private Reservation reservation;

    /**
     * 
     * @return
     *     returns Reservation
     */
    public Reservation getReservation() {
        return this.reservation;
    }

    /**
     * 
     * @param reservation
     *     the value for the reservation property
     */
    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

}
