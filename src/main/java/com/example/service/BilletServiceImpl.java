package com.example.service;

import com.example.model.Billet;
import com.example.model.Evenement;
import com.example.model.Reservation;
import com.example.repository.BilletRepository;
import com.example.repository.EvenementRepository;
import com.example.repository.ReservationRepository;

import javax.jws.WebService;

import java.math.BigDecimal;
import java.util.List;

@WebService(serviceName = "BilletService", portName = "BilletServicePort", targetNamespace = "http://service.example.com/", endpointInterface = "com.example.service.BilletService")
public class BilletServiceImpl implements BilletService {

    private BilletRepository billetRepository;
    private ReservationRepository reservationRepository;
    private EvenementRepository evenementRepository;

    public BilletServiceImpl() {
        // Initialize repositories
        this.billetRepository = new BilletRepository();
        this.reservationRepository = new ReservationRepository();
    }

    @Override
    public List<Billet> getBillets() {
        return billetRepository.findAll();
    }

    @Override
    public Billet creerBillet(Long evenementId, String categorie, BigDecimal prix, boolean disponible) {
        Evenement evenement = evenementRepository.findById(evenementId);
        if (evenement == null) {
            return null;
        }

        Billet billet = new Billet(evenement, categorie, prix, disponible);
        return billetRepository.save(billet);
    }

    @Override
    public boolean modifierBillet(Long id, String categorie, BigDecimal prix, boolean disponible) {
        Billet billet = billetRepository.findById(id);
        if (billet == null) {
            return false;
        }

        billet.setCategorie(categorie);
        billet.setPrix(prix);
        billet.setDisponible(disponible);

        return billetRepository.update(billet);
    }

    @Override
    public boolean supprimerBillet(Long id) {
        Billet billet = billetRepository.findById(id);
        if (billet == null) {
            return false;
        }

        List<Reservation> reservations = reservationRepository.findByBilletId(id);
        for (Reservation reservation : reservations) {
            reservation.setStatut("ANNULÉ");
            reservationRepository.update(reservation);
        }

        return billetRepository.delete(id);
    }

    @Override
    public Billet getBilletById(Long id) {
        return billetRepository.findById(id);
    }

    @Override
    public int creerBilletsEnMasse(Long evenementId, String categorie, BigDecimal prix, int nombreBillets) {
        Evenement evenement = evenementRepository.findById(evenementId);
        if (evenement == null) {
            return 0;
        }

        if (nombreBillets <= 0) {
            return 0;
        }

        int billetsExistants = billetRepository.countByEvenementId(evenementId);
        if (billetsExistants + nombreBillets > evenement.getCapaciteMax()) {
            nombreBillets = evenement.getCapaciteMax() - billetsExistants;
            if (nombreBillets <= 0) {
                return 0;
            }
        }

        int billetsCreesAvecSucces = 0;

        for (int i = 0; i < nombreBillets; i++) {
            Billet billet = new Billet(evenement, categorie, prix, true);
            Billet billetEnregistre = billetRepository.save(billet);
            if (billetEnregistre != null) {
                billetsCreesAvecSucces++;
            }
        }

        return billetsCreesAvecSucces;
    }

}
