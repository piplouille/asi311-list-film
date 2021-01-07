package com.ensta.myfilmlist.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ensta.myfilmlist.dto.GenreDTO;
import com.ensta.myfilmlist.model.Genre;
import com.ensta.myfilmlist.pojo.GenrePojo;

public class GenreMapper {
    public static GenreDTO genreToGenreDTO(Genre genre){
        return new GenreDTO(genre.getId(), genre.getGenre());
    }

    public static List<GenreDTO> listGenreToListGenreDTO(List<Genre> listGenre){
        List<GenreDTO> listGenreDTO = new ArrayList<>();
        for (Genre genre : listGenre ){
            listGenreDTO.add(genreToGenreDTO(genre));
        }
        return listGenreDTO;
    }

    public static Genre genrePojoToGenre(GenrePojo genre){
        return new Genre(genre.getId(), genre.getGenre());
    }

    public static List<Genre> listGenrePojoToListGenre(List<GenrePojo> listGenre){
        List<Genre> listGenreDTO = new ArrayList<>();
        for (GenrePojo genre : listGenre ){
            listGenreDTO.add(genrePojoToGenre(genre));
        }
        return listGenreDTO;
    }
    
    public static Genre genreDTOToGenre(GenreDTO genre) {
        return new Genre(genre.getId(), genre.getGenre());
    }

    public static GenrePojo genreGenreToPojo(Genre genre) {
        return new GenrePojo(genre.getId(), genre.getGenre());
    }
}