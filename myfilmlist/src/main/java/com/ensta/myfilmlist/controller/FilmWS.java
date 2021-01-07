package com.ensta.myfilmlist.controller;

import java.util.List;

import com.ensta.myfilmlist.dto.FilmDTO;
import com.ensta.myfilmlist.exception.ControllerException;
import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.service.FilmService;

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
@RestController("FilmWS")
@RequestMapping(value = "/films")
public class FilmWS {
    // Logger log = LoggerFactory.getLogger(FilmWS.class);

    private FilmService filmService;

    public FilmWS(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping
    @ApiOperation(value = "Récupère la liste des films")
    public ResponseEntity<List<FilmDTO>> retrieveFilm() throws ControllerException {
        try {
            // log.warn("msg");
            return ResponseEntity.status(HttpStatus.OK).body(filmService.findAll());
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage());
        }
        /* ajouter attrape exception pour vérifier fonctionnement */
    }

    @GetMapping(value = "/{p}")
    @ApiOperation(value = "Récupère la liste des films par page")
    public ResponseEntity<List<FilmDTO>> retrieveFilm(@PathVariable long p) throws ControllerException {
        try {
            // log.warn("msg");
            return ResponseEntity.status(HttpStatus.OK).body(filmService.findAllByPage(p));
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage());
        }
        /* ajouter attrape exception pour vérifier fonctionnement */
    }    

    @GetMapping(value = "/film/{id}")
    @ApiOperation(value = "Get film by id")
    public ResponseEntity<FilmDTO> getFilmId(@PathVariable long id) throws ControllerException {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(filmService.findById(id)); 
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage());
        }
    }
    
    @GetMapping(value = "/real/{id}")
    @ApiOperation(value = "Get film by realisateur id")
    public ResponseEntity<List<FilmDTO>> getFilmByRealisateurId(@PathVariable("id") long realId) throws ControllerException {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(filmService.findByRealisateurId(realId));
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Supprime le film avec cet id")
    public void deleteFilm(@PathVariable long id) throws ControllerException {
        try {
            System.out.println("Je try delete");
            filmService.deleteOne(id);
            System.out.println("J'ai fini de try delete");
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage());
        }
    }

    @PostMapping
    @ApiOperation(value="créer un film")
    public ResponseEntity<FilmDTO> createFilm(@RequestBody FilmDTO film) throws ControllerException {
        try {
            filmService.create(film);
            return ResponseEntity.status(HttpStatus.OK).body(film);
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage());
        }
    }

    @PutMapping
    @ApiOperation(value = "update d'un film")
    public ResponseEntity<FilmDTO> updateFilm(@RequestBody FilmDTO film) throws ControllerException {
        try {
            filmService.update(film);
            return ResponseEntity.status(HttpStatus.OK).body(film);
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage());
        }
    }
}