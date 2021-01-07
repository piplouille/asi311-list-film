package com.ensta.myfilmlist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ensta.myfilmlist.exception.DaoException;
import com.ensta.myfilmlist.persistence.ConnectionManager;
import com.ensta.myfilmlist.pojo.RealisateurPojo;

import org.springframework.stereotype.Repository;

@Repository
public class RealisateurDAO {
    private static final String FIND_REALISATEURS_QUERY = "SELECT id, prenom, nom, naissance FROM Realisateur;";
	private static final String CREATE_REALISATEURS_QUERY = "INSERT INTO Realisateur(prenom, nom, naissance) VALUES(?, ?, ?);";
	private static final String FIND_BY_ID_REALISATEURS_QUERY = "SELECT prenom, nom, naissance FROM Realisateur WHERE id = ?;";
	private static final String UPDATE_REALISATEURS_QUERY = "UPDATE Realisateur SET prenom = ?, nom = ?, naissance = ? WHERE id = ?;";
	private static final String DELETE_REALISATEURS_QUERY = "DELETE Realisateur WHERE id = ?;";

	/**
	 * @arguments none
	 * @return liste des REALISATEURS
	 * @throws DaoException
	 */
    public List<RealisateurPojo> findAll() throws DaoException {
		List<RealisateurPojo> resultList = new ArrayList<>();
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn.prepareStatement(FIND_REALISATEURS_QUERY);) {
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				RealisateurPojo realisateur = new RealisateurPojo(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4));

				resultList.add(realisateur);
			}
			return resultList;

		} catch (SQLException e) {
			throw new DaoException("Erreur lors du SELECT : " + e.getMessage());
		}
	}

	public RealisateurPojo findById(long id) throws DaoException {
		RealisateurPojo result;
		try (
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement statement = conn.prepareStatement(FIND_BY_ID_REALISATEURS_QUERY);
		)
		{
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			result = new RealisateurPojo(id, resultSet.getString(1), resultSet.getString(2), resultSet.getString(3));
			return result;
		} catch (SQLException e) {
			throw new DaoException("Erreur lors du SELECT by ID : " + e.getMessage());
		}
	}

	public void create(RealisateurPojo realisateur) throws DaoException {
		try (
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement statement = conn.prepareStatement(CREATE_REALISATEURS_QUERY);
		)
		{
			statement.setString(1, realisateur.getPrenom());
            statement.setString(2, realisateur.getNom());
            statement.setString(3, realisateur.getNaissance());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Erreur lors du INSERT : " + e.getMessage());
		}
	}

	public void update(RealisateurPojo realisateur) throws DaoException {
		try (
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement statement = conn.prepareStatement(UPDATE_REALISATEURS_QUERY);
		)
		{
            statement.setString(1, realisateur.getPrenom());
            statement.setString(2, realisateur.getNom());
			statement.setString(3, realisateur.getNaissance());
			statement.setLong(4, realisateur.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Erreur lors du UPDATE : " + e.getMessage());
		}
	}

	public void deleteOne(long id) throws DaoException {
		try (
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement statement = conn.prepareStatement(DELETE_REALISATEURS_QUERY);
		)
		{
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Erreur lors du DELETE : " + e.getMessage());
		}
	}
}