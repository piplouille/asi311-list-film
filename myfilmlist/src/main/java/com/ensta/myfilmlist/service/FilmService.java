package com.ensta.myfilmlist.service;

import java.util.List;
import java.util.ArrayList;

import com.ensta.myfilmlist.dao.FilmDAO;
import com.ensta.myfilmlist.dto.FilmDTO;
import com.ensta.myfilmlist.exception.DaoException;
import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.mapper.FilmMapper;
import com.ensta.myfilmlist.model.Film;

import org.springframework.stereotype.Service;

@Service
public class FilmService {

    private FilmDAO filmDAO;
    private RealisateurService realisateurService;

    public FilmService(FilmDAO filmDAO, RealisateurService realisateurService) {
        this.filmDAO = filmDAO;
        this.realisateurService = realisateurService;
    }

    public List<FilmDTO> findAll() throws ServiceException {
        List<Film> listFilmModel;
        List<Film> listResult = new ArrayList<>();
        try {
            listFilmModel = FilmMapper.listFilmPojoToListFilm(filmDAO.findAll());
            for (Film film : listFilmModel ){
                try {
                    String nom_realisateur = realisateurService.findById(film.getRealisateur()).getNom();
                    film.setNomRealisateur(nom_realisateur);
                    listResult.add(film);
                } catch (ServiceException e) {
                    this.deleteOne(film.getId());
                }
            }
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return FilmMapper.listFilmToListFilmDTO(listResult);
    }

    public List<FilmDTO> findAllByPage(long page) throws ServiceException {
        List<Film> listFilmModel;
        List<Film> listResult = new ArrayList<>();
        try {
            listFilmModel = FilmMapper.listFilmPojoToListFilm(filmDAO.findAllByPage(page));
            for (Film film : listFilmModel ){
                try {
                    String nom_realisateur = realisateurService.findById(film.getRealisateur()).getNom();
                    film.setNomRealisateur(nom_realisateur);
                    listResult.add(film);
                } catch (ServiceException e) {
                    this.deleteOne(film.getId());
                }
            }
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return FilmMapper.listFilmToListFilmDTO(listResult);
    }

    public FilmDTO findById(long id) throws ServiceException {
        Film film;
        String nom_realisateur;
        try {
            film = FilmMapper.filmPojoToFilm(filmDAO.findById(id));
            nom_realisateur = realisateurService.findById(film.getRealisateur()).getNom();
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());   
        }
        return FilmMapper.filmToFilmDTO(film, nom_realisateur);
    }

    public List<FilmDTO> findByRealisateurId(long realId) throws ServiceException {
        List<Film> listFilmModel;
        try {
            listFilmModel = FilmMapper.listFilmPojoToListFilm(filmDAO.findByRealisateurId(realId));
            for (Film film : listFilmModel ){
                String nom_realisateur = realisateurService.findById(film.getRealisateur()).getNom();
                film.setNomRealisateur(nom_realisateur);
            }
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return FilmMapper.listFilmToListFilmDTO(listFilmModel);
    }

    public void create(FilmDTO film) throws ServiceException {
        String nom_realisateur;
        try {
            nom_realisateur = realisateurService.findById(film.getRealisateur()).getNom();
            filmDAO.create(FilmMapper.filmFilmToPojo(FilmMapper.filmDTOToFilm(film, nom_realisateur)));
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void update(FilmDTO film) throws ServiceException {
        String nom_realisateur;
        try {
            nom_realisateur = film.getNomRealisateur();
            filmDAO.update(FilmMapper.filmFilmToPojo(FilmMapper.filmDTOToFilm(film, nom_realisateur)));
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void deleteOne(long filmId) throws ServiceException {
        try {
            System.out.println(">> Je try service delete");
            filmDAO.deleteOne(filmId);
            System.out.println(">> J'ai fini try service delete");
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}