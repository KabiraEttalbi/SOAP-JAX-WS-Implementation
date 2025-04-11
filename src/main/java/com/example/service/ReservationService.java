package com.example.service;

import com.example.model.Reservation;
import com.example.model.Utilisateur;
import com.example.model.Billet;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService(name = "ReservationService", targetNamespace = "http://service.example.com/")
public interface ReservationService {

    @WebMethod(operationName = "reserverBillet")
    @WebResult(name = "reservation")
    Reservation reserverBillet(
            @WebParam(name = "utilisateur") Utilisateur utilisateur,
            @WebParam(name = "billet") Billet billet);

    @WebMethod(operationName = "annulerReservation")
    @WebResult(name = "success")
    boolean annulerReservation(@WebParam(name = "id") Long id);

    @WebMethod(operationName = "modifierReservation")
    @WebResult(name = "success")
    boolean modifierReservation(
            @WebParam(name = "id") Long id,
            @WebParam(name = "statut") String statut);

    @WebMethod(operationName = "getReservationById")
    @WebResult(name = "reservation")
    Reservation getReservationById(@WebParam(name = "id") Long id);

    @WebMethod(operationName = "getAllReservations")
    @WebResult(name = "reservations")
    List<Reservation> getAllReservations();
}