package com.example;

import javax.xml.ws.Endpoint;

import com.example.service.BilletServiceImpl;
import com.example.service.EvenementServiceImpl;
import com.example.service.ReservationServiceImpl;
import com.example.service.UtilisateurServiceImpl;

public class Main {
    public static void main(String[] args) {
        try {
            BilletServiceImpl billetService = new BilletServiceImpl();
            EvenementServiceImpl evenementService = new EvenementServiceImpl();
            ReservationServiceImpl reservationService = new ReservationServiceImpl();
            UtilisateurServiceImpl utilisateurService = new UtilisateurServiceImpl();
            String baseAddress = "http://localhost:8080/";

            Endpoint.publish(baseAddress + "utilisateurservice", utilisateurService);
            System.out.println("Service Utilisateur publié à l'adresse : " + baseAddress + "utilisateurservice");

            Endpoint.publish(baseAddress + "evenementservice", evenementService);
            System.out.println("Service Événement publié à l'adresse : " + baseAddress + "evenementservice");

            Endpoint.publish(baseAddress + "billetservice", billetService);
            System.out.println("Service Billet publié à l'adresse : " + baseAddress + "billetservice");

            Endpoint.publish(baseAddress + "reservationservice", reservationService);
            System.out.println("Service Réservation publié à l'adresse : " + baseAddress + "reservationservice");

            System.out.println("Tous les services ont été publiés avec succès!");
        } catch (Exception e) {
            System.err.println("Erreur lors du démarrage des services: " + e.getMessage());
            e.printStackTrace();
        }
    }
}