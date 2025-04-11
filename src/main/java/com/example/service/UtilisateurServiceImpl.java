package com.example.service;

import com.example.model.Utilisateur;
import com.example.model.Billet;
import com.example.model.Reservation;
import com.example.repository.UtilisateurRepository;
import com.example.repository.BilletRepository;
import com.example.repository.ReservationRepository;

import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "UtilisateurService", portName = "UtilisateurServicePort", targetNamespace = "http://service.example.com/", endpointInterface = "com.example.service.UtilisateurService")
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurRepository utilisateurRepository;
    private ReservationRepository reservationRepository;
    private BilletRepository billetRepository;

    public UtilisateurServiceImpl() {
        this.utilisateurRepository = new UtilisateurRepository();
        this.reservationRepository = new ReservationRepository();
        this.billetRepository = new BilletRepository();
    }

    @Override
    public Utilisateur inscrireUtilisateur(String nom, String email, String motDePasse) {
        if (utilisateurRepository.findByEmail(email) != null) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur(nom, email, motDePasse);
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur connecterUtilisateur(String email, String motDePasse) {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email);
        if (utilisateur != null && utilisateur.getMotDePasse().equals(motDePasse)) {
            return utilisateur;
        }
        return null;
    }

    @Override
    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id);
    }

    @Override
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @Override
    public boolean modifierUtilisateur(Long id, String nom, String email, String motDePasse) {
        Utilisateur utilisateur = utilisateurRepository.findById(id);
        if (utilisateur == null) {
            return false;
        }

        Utilisateur existingUser = utilisateurRepository.findByEmail(email);
        if (existingUser != null && !existingUser.getId().equals(id)) {
            return false;
        }

        utilisateur.setNom(nom);
        utilisateur.setEmail(email);
        utilisateur.setMotDePasse(motDePasse);

        return utilisateurRepository.update(utilisateur);
    }

    @Override
    public boolean supprimerUtilisateur(Long id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id);
        if (utilisateur == null) {
            return false;
        }

        List<Reservation> reservations = reservationRepository.findByUtilisateurId(id);
        for (Reservation reservation : reservations) {
            reservation.setStatut("ANNULÉ");
            reservationRepository.update(reservation);

            Billet billet = reservation.getBillet();
            billet.setDisponible(true);
            billetRepository.update(billet);
        }

        return utilisateurRepository.delete(id);
    }

    @Override
    public List<Reservation> getReservationsUtilisateur(Long id) {
        return reservationRepository.findByUtilisateurId(id);
    }

}