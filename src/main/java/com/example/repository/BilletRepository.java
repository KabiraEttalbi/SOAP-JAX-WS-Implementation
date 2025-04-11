package com.example.repository;

import com.example.model.Billet;
import com.example.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BilletRepository {

    private Connection connection;
    private EvenementRepository evenementRepository;

    public BilletRepository() {
        this.connection = DatabaseConnection.getConnection();
        this.evenementRepository = new EvenementRepository();
    }

    public List<Billet> findAll() {
        List<Billet> billets = new ArrayList<>();
        String sql = "SELECT * FROM billets";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Billet billet = mapResultSetToBillet(rs);
                billets.add(billet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return billets;
    }

    public Billet findById(Long id) {
        String sql = "SELECT * FROM billets WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToBillet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Billet> findByEvenementId(Long evenementId) {
        List<Billet> billets = new ArrayList<>();
        String sql = "SELECT * FROM billets WHERE evenement_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, evenementId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    billets.add(mapResultSetToBillet(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return billets;
    }

    public boolean delete(Long id) {
        String sql = "DELETE FROM billets WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Billet save(Billet billet) {
        String sql = "INSERT INTO billets (evenement_id, categorie, prix, disponible) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setLong(1, billet.getEvenement().getId());
            stmt.setString(2, billet.getCategorie());
            stmt.setBigDecimal(3, billet.getPrix());
            stmt.setBoolean(4, billet.isDisponible());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        billet.setId(generatedKeys.getLong(1));
                        return billet;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean update(Billet billet) {
        String sql = "UPDATE billets SET evenement_id = ?, categorie = ?, prix = ?, disponible = ? WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, billet.getEvenement().getId());
            stmt.setString(2, billet.getCategorie());
            stmt.setBigDecimal(3, billet.getPrix());
            stmt.setBoolean(4, billet.isDisponible());
            stmt.setLong(5, billet.getId());

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Billet mapResultSetToBillet(ResultSet rs) throws SQLException {
        Billet billet = new Billet();
        billet.setId(rs.getLong("id"));
        billet.setEvenement(evenementRepository.findById(rs.getLong("evenement_id")));
        billet.setCategorie(rs.getString("categorie"));
        billet.setPrix(rs.getBigDecimal("prix"));
        billet.setDisponible(rs.getBoolean("disponible"));
        return billet;
    }

    public int countByEvenementId(Long evenementId) {
        String sql = "SELECT COUNT(*) FROM billets WHERE evenement_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, evenementId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
