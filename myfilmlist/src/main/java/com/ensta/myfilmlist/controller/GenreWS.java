package com.ensta.myfilmlist.controller;

import java.util.List;

import com.ensta.myfilmlist.dto.GenreDTO;
import com.ensta.myfilmlist.exception.ControllerException;
import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.service.GenreService;

// import org.slf4j.Logger;
// import org.slf4J.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("GenreWS")
@RequestMapping(value = "/genres")
public class GenreWS {
    private GenreService genreService;

    public GenreWS(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    @ApiOperation(value = "Récupère la liste des genres")
    public ResponseEntity<List<GenreDTO>> retrieveGenre() throws ControllerException {
        try {
            // log.warn("msg");
            return ResponseEntity.status(HttpStatus.OK).body(genreService.findAll());
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage());
        }
        /* ajouter attrape exception pour vérifier fonctionnement */
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Get genre by id")
    public ResponseEntity<GenreDTO> getGenreId(@PathVariable long id) throws ControllerException {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(genreService.findById(id)); 
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage());
        }
    }
}