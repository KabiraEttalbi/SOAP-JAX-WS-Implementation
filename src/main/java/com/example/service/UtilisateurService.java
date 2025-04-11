package com.example.service;

import com.example.model.Utilisateur;
import com.example.model.Reservation;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService(name = "UtilisateurService", targetNamespace = "http://service.example.com/")
public interface UtilisateurService {

        @WebMethod(operationName = "inscrireUtilisateur")
        @WebResult(name = "utilisateur")
        Utilisateur inscrireUtilisateur(
                        @WebParam(name = "nom") String nom,
                        @WebParam(name = "email") String email,
                        @WebParam(name = "motDePasse") String motDePasse);

        @WebMethod(operationName = "connecterUtilisateur")
        @WebResult(name = "utilisateur")
        Utilisateur connecterUtilisateur(
                        @WebParam(name = "email") String email,
                        @WebParam(name = "motDePasse") String motDePasse);

        @WebMethod(operationName = "modifierUtilisateur")
        @WebResult(name = "success")
        boolean modifierUtilisateur(
                        @WebParam(name = "id") Long id,
                        @WebParam(name = "nom") String nom,
                        @WebParam(name = "email") String email,
                        @WebParam(name = "motDePasse") String motDePasse);

        @WebMethod(operationName = "supprimerUtilisateur")
        @WebResult(name = "success")
        boolean supprimerUtilisateur(@WebParam(name = "id") Long id);

        @WebMethod(operationName = "getUtilisateurById")
        @WebResult(name = "utilisateur")
        Utilisateur getUtilisateurById(@WebParam(name = "id") Long id);

        @WebMethod(operationName = "getUtilisateurs")
        @WebResult(name = "utilisateurs")
        List<Utilisateur> getUtilisateurs();

        @WebMethod(operationName = "getReservationsUtilisateur")
        @WebResult(name = "reservations")
        List<Reservation> getReservationsUtilisateur(@WebParam(name = "id") Long id);
}