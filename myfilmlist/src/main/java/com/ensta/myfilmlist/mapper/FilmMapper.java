package com.ensta.myfilmlist.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ensta.myfilmlist.dto.FilmDTO;
import com.ensta.myfilmlist.model.Film;
import com.ensta.myfilmlist.pojo.FilmPojo;

public class FilmMapper {

    public static FilmDTO filmToFilmDTO(Film film, String nom_realisateur){
        return new FilmDTO(film.getId(),film.getTitre(), film.getDuration(), film.getRealisateur(), nom_realisateur, film.getGenre());
    }

    public static List<FilmDTO> listFilmToListFilmDTO(List<Film> listFilm){
        List<FilmDTO> listFilmDTO = new ArrayList<>();
        for (Film film : listFilm ){
            listFilmDTO.add(filmToFilmDTO(film, film.getNomRealisateur()));
        }
        return listFilmDTO;
    }

    public static Film filmPojoToFilm(FilmPojo film){
        return new Film(film.getId(),film.getTitre(), film.getDuration(), film.getRealisateur(), film.getNomRealisateur(), film.getGenre());
    }

    public static List<Film> listFilmPojoToListFilm(List<FilmPojo> listFilm){
        List<Film> listFilmDTO = new ArrayList<>();
        for (FilmPojo film : listFilm ){
            listFilmDTO.add(filmPojoToFilm(film));
        }
        return listFilmDTO;
    }

    public static Film filmDTOToFilm(FilmDTO film, String nom_realisateur) {
        return new Film(film.getId(), film.getTitre(), film.getDuration(), film.getRealisateur(), nom_realisateur, film.getGenre());
    }

    public static FilmPojo filmFilmToPojo(Film film) {
        return new FilmPojo(film.getId(), film.getTitre(), film.getDuration(), film.getRealisateur(), film.getNomRealisateur(), film.getGenre());
    }
}