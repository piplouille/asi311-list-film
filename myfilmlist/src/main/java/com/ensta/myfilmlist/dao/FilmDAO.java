package com.ensta.myfilmlist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ensta.myfilmlist.exception.DaoException;
import com.ensta.myfilmlist.persistence.ConnectionManager;
import com.ensta.myfilmlist.pojo.FilmPojo;
import com.ensta.myfilmlist.pojo.RealisateurPojo;

import org.springframework.stereotype.Repository;

@Repository
public class FilmDAO {
	private static final String FIND_FILMS_QUERY = "SELECT id, titre, duration, id_realisateur FROM Film;";
	private static final String FIND_FILMS_QUERY_PAGE = "SELECT id, titre, duration, id_realisateur FROM Film LIMIT 5 OFFSET ?;";
	private static final String CREATE_FILMS_QUERY = "INSERT INTO Film(titre, duration, id_realisateur) VALUES(?, ?, ?);";
	private static final String FIND_BY_ID_FILMS_QUERY = "SELECT titre, duration, id_realisateur FROM Film WHERE id = ?;";
	private static final String UPDATE_FILMS_QUERY = "UPDATE Film SET titre = ?, duration = ?, id_realisateur = ? WHERE id = ?;";
	private static final String DELETE_FILMS_QUERY = "DELETE Film WHERE id = ?;";
	private static final String FIND_BY_REAL_ID_FILMS_QUERY = "SELECT id, titre, duration, id_realisateur FROM Film WHERE id_realisateur = ?;";

	/**
	 * @arguments none
	 * @return liste des films
	 * @throws DaoException
	 */
    public List<FilmPojo> findAll() throws DaoException {
		List<FilmPojo> resultList = new ArrayList<>();
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn.prepareStatement(FIND_FILMS_QUERY);) {
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				FilmPojo film = new FilmPojo(resultSet.getLong(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getLong(4), "");

				resultList.add(film);
			}
			return resultList;

		} catch (SQLException e) {
			throw new DaoException("Erreur lors du SELECT : " + e.getMessage());
		}
	}

	public List<FilmPojo> findAllByPage(long page) throws DaoException {
		List<FilmPojo> resultList = new ArrayList<>();
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn.prepareStatement(FIND_FILMS_QUERY_PAGE);) {
			statement.setLong(1, (page - 1) * 5);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {

				FilmPojo film = new FilmPojo(resultSet.getLong(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getLong(4), "");

				resultList.add(film);
			}
			return resultList;

		} catch (SQLException e) {
			throw new DaoException("Erreur lors du SELECT by page : " + e.getMessage());
		}
	}

	public FilmPojo findById(long id) throws DaoException {
		FilmPojo result;
		try (
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement statement = conn.prepareStatement(FIND_BY_ID_FILMS_QUERY);
		)
		{
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			result = new FilmPojo(id, resultSet.getString(1), resultSet.getInt(2), resultSet.getLong(3), "");
			return result;
		} catch (SQLException e) {
			throw new DaoException("Erreur lors du SELECT by ID : " + e.getMessage());
		}
	}

	public List<FilmPojo> findByRealisateurId(long realId) throws DaoException {
		List<FilmPojo> resultList = new ArrayList<>();
		try (
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement statement = conn.prepareStatement(FIND_BY_REAL_ID_FILMS_QUERY);
		)
		{
			statement.setLong(1, realId);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				FilmPojo film = new FilmPojo(resultSet.getLong(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getLong(4), "");
				resultList.add(film);
			}
		return resultList;

		} catch (SQLException e) {
			throw new DaoException("Erreur lors du SELECT : " + e.getMessage());
		}
	}

	public void create(FilmPojo film) throws DaoException {
		try (
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement statement = conn.prepareStatement(CREATE_FILMS_QUERY);
		)
		{
			statement.setString(1, film.getTitre());
			statement.setInt(2, film.getDuration());
			statement.setLong(3, film.getRealisateur());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Erreur lors du INSERT : " + e.getMessage());
		}
	}

	public void update(FilmPojo film) throws DaoException {
		try (
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement statement = conn.prepareStatement(UPDATE_FILMS_QUERY);
		)
		{
			statement.setString(1, film.getTitre());
			statement.setInt(2, film.getDuration());
			statement.setLong(3, film.getRealisateur());
			statement.setLong(4, film.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Erreur lors du UPDATE : " + e.getMessage());
		}
	}

	public void deleteOne(long id) throws DaoException {
		try (
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement statement = conn.prepareStatement(DELETE_FILMS_QUERY);
		)
		{
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException("Erreur lors du DELETE : " + e.getMessage());
		}
	}
}