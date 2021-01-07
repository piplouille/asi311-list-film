package com.ensta.myfilmlist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ensta.myfilmlist.exception.DaoException;
import com.ensta.myfilmlist.persistence.ConnectionManager;
import com.ensta.myfilmlist.pojo.GenrePojo;

import org.springframework.stereotype.Repository;

@Repository
public class GenreDAO {
    private static final String FIND_GENRES_QUERY = "SELECT id, genre FROM Genre;";
	private static final String FIND_BY_ID_GENRES_QUERY = "SELECT id, genre FROM Genre WHERE id = ?;";

    /**
	 * @arguments none
	 * @return liste des genres
	 * @throws DaoException
	 */
    public List<GenrePojo> findAll() throws DaoException {
		List<GenrePojo> resultList = new ArrayList<>();
		try (Connection conn = ConnectionManager.getConnection();
				PreparedStatement statement = conn.prepareStatement(FIND_GENRES_QUERY);) {
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				GenrePojo genre = new GenrePojo(resultSet.getLong(1), resultSet.getString(2));

				resultList.add(genre);
			}
			return resultList;

		} catch (SQLException e) {
			throw new DaoException("Erreur lors du SELECT : " + e.getMessage());
		}
    }
    
    public GenrePojo findById(long id) throws DaoException {
		GenrePojo result;
		try (
			Connection conn = ConnectionManager.getConnection();
			PreparedStatement statement = conn.prepareStatement(FIND_BY_ID_GENRES_QUERY);
		)
		{
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			result = new GenrePojo(id, resultSet.getString(1));
			return result;
		} catch (SQLException e) {
			throw new DaoException("Erreur lors du SELECT by ID : " + e.getMessage());
		}
	}

}