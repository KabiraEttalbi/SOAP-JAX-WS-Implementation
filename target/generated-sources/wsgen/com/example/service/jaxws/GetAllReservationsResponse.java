
package com.example.service.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.example.model.Reservation;

@XmlRootElement(name = "getAllReservationsResponse", namespace = "http://service.example.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAllReservationsResponse", namespace = "http://service.example.com/")
public class GetAllReservationsResponse {

    @XmlElement(name = "reservations", namespace = "")
    private List<Reservation> reservations;

    /**
     * 
     * @return
     *     returns List&lt;Reservation&gt;
     */
    public List<Reservation> getReservations() {
        return this.reservations;
    }

    /**
     * 
     * @param reservations
     *     the value for the reservations property
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}
