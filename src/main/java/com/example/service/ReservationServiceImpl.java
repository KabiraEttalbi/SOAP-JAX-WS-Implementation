package com.example.service;

import com.example.model.Reservation;
import com.example.model.Utilisateur;
import com.example.model.Billet;
import com.example.repository.ReservationRepository;
import com.example.repository.UtilisateurRepository;
import com.example.repository.BilletRepository;

import javax.jws.WebService;
import java.util.Date;
import java.util.List;

@WebService(serviceName = "ReservationService", portName = "ReservationServicePort", targetNamespace = "http://service.example.com/", endpointInterface = "com.example.service.ReservationService")
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;
    private UtilisateurRepository utilisateurRepository;
    private BilletRepository billetRepository;

    public ReservationServiceImpl() {
        this.reservationRepository = new ReservationRepository();
        this.utilisateurRepository = new UtilisateurRepository();
        this.billetRepository = new BilletRepository();
    }

    @Override
    public Reservation reserverBillet(Utilisateur utilisateur, Billet billet) {
        // Vérifier si le billet est disponible
        Billet billetDb = billetRepository.findById(billet.getId());
        if (billetDb == null || !billetDb.isDisponible()) {
            return null;
        }

        // Vérifier si l'utilisateur existe
        Utilisateur utilisateurDb = utilisateurRepository.findById(utilisateur.getId());
        if (utilisateurDb == null) {
            return null;
        }

        // Créer la réservation
        Reservation reservation = new Reservation(utilisateurDb, billetDb, new Date(), "CONFIRMÉ");
        reservation = reservationRepository.save(reservation);

        // Mettre à jour le statut du billet
        billetDb.setDisponible(false);
        billetRepository.update(billetDb);

        return reservation;
    }

    @Override
    public boolean annulerReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id);
        if (reservation == null) {
            return false;
        }

        reservation.setStatut("ANNULÉ");
        reservationRepository.update(reservation);

        Billet billet = reservation.getBillet();
        billet.setDisponible(true);
        billetRepository.update(billet);

        return true;
    }

    @Override
    public boolean modifierReservation(Long id, String statut) {
        Reservation reservation = reservationRepository.findById(id);
        if (reservation == null) {
            return false;
        }

        String ancienStatut = reservation.getStatut();
        reservation.setStatut(statut);

        if ("CONFIRMÉ".equals(ancienStatut) && "ANNULÉ".equals(statut)) {
            Billet billet = reservation.getBillet();
            billet.setDisponible(true);
            billetRepository.update(billet);
        } else if ("ANNULÉ".equals(ancienStatut) && "CONFIRMÉ".equals(statut)) {
            Billet billet = reservation.getBillet();
            billet.setDisponible(false);
            billetRepository.update(billet);
        }

        return reservationRepository.update(reservation);
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

}