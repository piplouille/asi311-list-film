package com.ensta.myfilmlist.service;

import java.util.List;

import com.ensta.myfilmlist.dao.GenreDAO;
import com.ensta.myfilmlist.dto.GenreDTO;
import com.ensta.myfilmlist.exception.DaoException;
import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.mapper.GenreMapper;
import com.ensta.myfilmlist.model.Genre;

import org.springframework.stereotype.Service;

@Service
public class GenreService {
    private GenreDAO genreDAO;

    public GenreService(GenreDAO genreDAO) {
        this.genreDAO = genreDAO;
    }

    public List<GenreDTO> findAll() throws ServiceException {
        List<Genre> listGenreModel;
        try {
            listGenreModel = GenreMapper.listGenrePojoToListGenre(genreDAO.findAll());
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return GenreMapper.listGenreToListGenreDTO(listGenreModel);
    }

    public GenreDTO findById(long id) throws ServiceException {
        Genre genre;
        try {
            genre = GenreMapper.genrePojoToGenre(genreDAO.findById(id));
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());   
        }
        return GenreMapper.genreToGenreDTO(genre);
    }
}