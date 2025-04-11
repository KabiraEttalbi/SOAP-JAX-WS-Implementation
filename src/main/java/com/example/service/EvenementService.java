package com.example.service;

import com.example.model.Evenement;
import com.example.model.Billet;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.sql.Date;
import java.util.List;

@WebService(name = "EvenementService", targetNamespace = "http://service.example.com/")
public interface EvenementService {

    @WebMethod(operationName = "creerEvenement")
    @WebResult(name = "evenement")
    Evenement creerEvenement(
            @WebParam(name = "nom") String nom,
            @WebParam(name = "lieu") String lieu,
            @WebParam(name = "date") Date date,
            @WebParam(name = "description") String description,
            @WebParam(name = "capaciteMax") int capaciteMax);

    @WebMethod(operationName = "modifierEvenement")
    @WebResult(name = "success")
    boolean modifierEvenement(
            @WebParam(name = "id") Long id,
            @WebParam(name = "nom") String nom,
            @WebParam(name = "lieu") String lieu,
            @WebParam(name = "date") Date date,
            @WebParam(name = "description") String description,
            @WebParam(name = "capaciteMax") int capaciteMax);

    @WebMethod(operationName = "supprimerEvenement")
    @WebResult(name = "success")
    boolean supprimerEvenement(@WebParam(name = "id") Long id);

    @WebMethod(operationName = "getEvenements")
    @WebResult(name = "evenements")
    List<Evenement> getEvenements();

    @WebMethod(operationName = "getEvenementById")
    @WebResult(name = "evenement")
    Evenement getEvenementById(@WebParam(name = "id") Long id);

    @WebMethod(operationName = "getBilletsByEvenement")
    @WebResult(name = "billets")
    List<Billet> getBilletsByEvenement(@WebParam(name = "evenementId") Long evenementId);

    @WebMethod(operationName = "getNombreReservationsParEvenement")
    @WebResult(name = "nombreReservations")
    int getNombreReservationsParEvenement(@WebParam(name = "evenementId") Long evenementId);
}