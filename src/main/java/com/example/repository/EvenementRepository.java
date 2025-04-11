package com.example.repository;

import com.example.model.Evenement;
import com.example.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EvenementRepository {

    private Connection connection;

    public EvenementRepository() {
        this.connection = DatabaseConnection.getConnection();
    }

    public Evenement save(Evenement evenement) {
        String sql = "INSERT INTO evenements (nom, lieu, date, description, capacite_max) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, evenement.getNom());
            stmt.setString(2, evenement.getLieu());
            stmt.setTimestamp(3, new Timestamp(evenement.getDate().getTime()));
            stmt.setString(4, evenement.getDescription());
            stmt.setInt(5, evenement.getCapaciteMax());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        evenement.setId(generatedKeys.getLong(1));
                        return evenement;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean update(Evenement evenement) {
        String sql = "UPDATE evenements SET nom = ?, lieu = ?, date = ?, description = ?, capacite_max = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, evenement.getNom());
            stmt.setString(2, evenement.getLieu());
            stmt.setTimestamp(3, new Timestamp(evenement.getDate().getTime()));
            stmt.setString(4, evenement.getDescription());
            stmt.setInt(5, evenement.getCapaciteMax());
            stmt.setLong(6, evenement.getId());

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Long id) {
        String sql = "DELETE FROM evenements WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Evenement> findAll() {
        List<Evenement> evenements = new ArrayList<>();
        String sql = "SELECT * FROM evenements";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                evenements.add(mapResultSetToEvenement(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return evenements;
    }

    public Evenement findById(Long id) {
        String sql = "SELECT * FROM evenements WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToEvenement(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Evenement mapResultSetToEvenement(ResultSet rs) throws SQLException {
        Evenement evenement = new Evenement();
        evenement.setId(rs.getLong("id"));
        evenement.setNom(rs.getString("nom"));
        evenement.setLieu(rs.getString("lieu"));
        evenement.setDate(rs.getTimestamp("date"));
        evenement.setDescription(rs.getString("description"));
        evenement.setCapaciteMax(rs.getInt("capacite_max"));
        return evenement;
    }
}
