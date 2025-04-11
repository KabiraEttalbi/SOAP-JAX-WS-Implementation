package com.example.service;

import com.example.model.Evenement;
import com.example.model.Billet;
import com.example.model.Reservation;
import com.example.repository.EvenementRepository;
import com.example.repository.BilletRepository;
import com.example.repository.ReservationRepository;

import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "EvenementService", portName = "EvenementServicePort", targetNamespace = "http://service.example.com/", endpointInterface = "com.example.service.EvenementService")
public class EvenementServiceImpl implements EvenementService {

    private EvenementRepository evenementRepository;
    private BilletRepository billetRepository;
    private ReservationRepository reservationRepository;

    public EvenementServiceImpl() {
        this.evenementRepository = new EvenementRepository();
        this.billetRepository = new BilletRepository();
        this.reservationRepository = new ReservationRepository();
    }

    @Override
    public Evenement creerEvenement(String nom, String lieu, java.sql.Date date, String description, int capaciteMax) {
        Evenement evenement = new Evenement(nom, lieu, date, description, capaciteMax);
        return evenementRepository.save(evenement);
    }

    @Override
    public boolean modifierEvenement(Long id, String nom, String lieu, java.sql.Date date, String description,
            int capaciteMax) {
        Evenement evenement = evenementRepository.findById(id);
        if (evenement == null) {
            return false;
        }

        evenement.setNom(nom);
        evenement.setLieu(lieu);
        evenement.setDate(date);
        evenement.setDescription(description);
        evenement.setCapaciteMax(capaciteMax);

        return evenementRepository.update(evenement);
    }

    @Override
    public boolean supprimerEvenement(Long id) {
        Evenement evenement = evenementRepository.findById(id);
        if (evenement == null) {
            return false;
        }

        List<Billet> billets = billetRepository.findByEvenementId(id);
        for (Billet billet : billets) {
            List<Reservation> reservations = reservationRepository.findByBilletId(billet.getId());
            for (Reservation reservation : reservations) {
                reservation.setStatut("ANNULÉ");
                reservationRepository.update(reservation);
            }
            billetRepository.delete(billet.getId());
        }

        return evenementRepository.delete(id);
    }

    @Override
    public List<Evenement> getEvenements() {
        return evenementRepository.findAll();
    }

    @Override
    public Evenement getEvenementById(Long id) {
        return evenementRepository.findById(id);
    }

    @Override
    public List<Billet> getBilletsByEvenement(Long evenementId) {
        return billetRepository.findByEvenementId(evenementId);
    }

    @Override
    public int getNombreReservationsParEvenement(Long evenementId) {
        Evenement evenement = evenementRepository.findById(evenementId);
        if (evenement == null) {
            return 0;
        }

        int nombreReservations = 0;
        List<Billet> billets = billetRepository.findByEvenementId(evenementId);

        for (Billet billet : billets) {
            List<Reservation> reservations = reservationRepository.findByBilletId(billet.getId());
            for (Reservation reservation : reservations) {
                if ("CONFIRMÉ".equals(reservation.getStatut()) || "PAYÉ".equals(reservation.getStatut())) {
                    nombreReservations++;
                }
            }
        }

        return nombreReservations;
    }
}