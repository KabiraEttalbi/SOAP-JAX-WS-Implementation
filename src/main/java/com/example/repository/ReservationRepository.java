package com.example.repository;

import com.example.model.Reservation;
import com.example.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {

    private Connection connection;
    private UtilisateurRepository utilisateurRepository;
    private BilletRepository billetRepository;

    public ReservationRepository() {
        this.connection = DatabaseConnection.getConnection();
        this.utilisateurRepository = new UtilisateurRepository();
        this.billetRepository = new BilletRepository();
    }

    public Reservation findById(Long id) {
        String sql = "SELECT * FROM reservations WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToReservation(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Reservation> findByUtilisateurId(Long utilisateurId) {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations WHERE utilisateur_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, utilisateurId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    reservations.add(mapResultSetToReservation(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservations;
    }

    public List<Reservation> findAll() {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                reservations.add(mapResultSetToReservation(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservations;
    }

    public List<Reservation> findByBilletId(Long billetId) {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations WHERE billet_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, billetId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    reservations.add(mapResultSetToReservation(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservations;
    }

    public List<Reservation> findByPeriode(Date dateDebut, Date dateFin) {
        List<Reservation> reservations = new ArrayList<>();
        String sql = "SELECT * FROM reservations WHERE date_reservation BETWEEN ? AND ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setTimestamp(1, new Timestamp(dateDebut.getTime()));
            stmt.setTimestamp(2, new Timestamp(dateFin.getTime()));

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    reservations.add(mapResultSetToReservation(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reservations;
    }

    public Reservation save(Reservation reservation) {
        String sql = "INSERT INTO reservations (utilisateur_id, billet_id, date_reservation, statut) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setLong(1, reservation.getUtilisateur().getId());
            stmt.setLong(2, reservation.getBillet().getId());
            stmt.setTimestamp(3, new Timestamp(reservation.getDateReservation().getTime()));
            stmt.setString(4, reservation.getStatut());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        reservation.setId(generatedKeys.getLong(1));
                        return reservation;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean update(Reservation reservation) {
        String sql = "UPDATE reservations SET utilisateur_id = ?, billet_id = ?, date_reservation = ?, statut = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, reservation.getUtilisateur().getId());
            stmt.setLong(2, reservation.getBillet().getId());
            stmt.setTimestamp(3, new Timestamp(reservation.getDateReservation().getTime()));
            stmt.setString(4, reservation.getStatut());
            stmt.setLong(5, reservation.getId());

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Reservation mapResultSetToReservation(ResultSet rs) throws SQLException {
        Reservation reservation = new Reservation();
        reservation.setId(rs.getLong("id"));
        reservation.setUtilisateur(utilisateurRepository.findById(rs.getLong("utilisateur_id")));
        reservation.setBillet(billetRepository.findById(rs.getLong("billet_id")));
        reservation.setDateReservation(rs.getTimestamp("date_reservation"));
        reservation.setStatut(rs.getString("statut"));
        return reservation;
    }
}
