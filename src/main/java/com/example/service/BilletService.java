package com.example.service;

import com.example.model.Billet;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.math.BigDecimal;
import java.util.List;

@WebService(name = "BilletService", targetNamespace = "http://service.example.com/")
public interface BilletService {

        @WebMethod(operationName = "getBillets")
        @WebResult(name = "billets")
        List<Billet> getBillets();

        @WebMethod(operationName = "creerBillet")
        @WebResult(name = "billet")
        Billet creerBillet(
                        @WebParam(name = "evenementId") Long evenementId,
                        @WebParam(name = "categorie") String categorie,
                        @WebParam(name = "prix") BigDecimal prix,
                        @WebParam(name = "disponible") boolean disponible);

        @WebMethod(operationName = "modifierBillet")
        @WebResult(name = "success")
        boolean modifierBillet(
                        @WebParam(name = "id") Long id,
                        @WebParam(name = "categorie") String categorie,
                        @WebParam(name = "prix") BigDecimal prix,
                        @WebParam(name = "disponible") boolean disponible);

        @WebMethod(operationName = "supprimerBillet")
        @WebResult(name = "success")
        boolean supprimerBillet(@WebParam(name = "id") Long id);

        @WebMethod(operationName = "getBilletById")
        @WebResult(name = "billet")
        Billet getBilletById(@WebParam(name = "id") Long id);

        @WebMethod(operationName = "creerBilletsEnMasse")
        @WebResult(name = "nombreBilletsCrees")
        int creerBilletsEnMasse(
                        @WebParam(name = "evenementId") Long evenementId,
                        @WebParam(name = "categorie") String categorie,
                        @WebParam(name = "prix") BigDecimal prix,
                        @WebParam(name = "nombreBillets") int nombreBillets);
}