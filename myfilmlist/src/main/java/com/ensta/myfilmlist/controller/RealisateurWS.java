package com.ensta.myfilmlist.controller;

import java.util.List;

import com.ensta.myfilmlist.dto.RealisateurDTO;
import com.ensta.myfilmlist.exception.ControllerException;
import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.service.RealisateurService;

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
import org.springframework.web.bind.annotation.CrossOrigin;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController("RealisateurWS")
@RequestMapping(value = "/realisateur")
public class RealisateurWS {
    // Logger log = LoggerFactory.getLogger(RealisateurWS.class);

    private RealisateurService realisateurService;

    public RealisateurWS(RealisateurService realisateurService) {
        this.realisateurService = realisateurService;
    }

    @GetMapping
    @ApiOperation(value = "Récupère la liste des realisateurs")
    public ResponseEntity<List<RealisateurDTO>> retrieveRealisateur() throws ControllerException {
        try {
            // log.warn("msg");
            return ResponseEntity.status(HttpStatus.OK).body(realisateurService.findAll());
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage());
        }
        /* ajouter attrape exception pour vérifier fonctionnement */
    }

    @GetMapping(value = "{id}")
    @ApiOperation(value = "Get realisateur by id")
    public ResponseEntity<RealisateurDTO> getRealisateurId(@PathVariable long id) throws ControllerException {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(realisateurService.findById(id)); 
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage());
        }
    }

    @DeleteMapping("{realisateurId}")
    @ApiOperation(value = "Supprime le realisateur avec cet id")
    public void deleteRealisateur(@PathVariable long realisateurId) throws ControllerException {
        try {
            realisateurService.deleteOne(realisateurId);
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage());
        }
    }

    @PostMapping
    @ApiOperation(value="créer un realisateur")
    public ResponseEntity<RealisateurDTO> createRealisateur(@RequestBody RealisateurDTO realisateur) throws ControllerException {
        try {
            realisateurService.create(realisateur);
            return ResponseEntity.status(HttpStatus.OK).body(realisateur);
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage());
        }
    }

    @PutMapping
    @ApiOperation(value = "update d'un realisateur")
    public ResponseEntity<RealisateurDTO> updateRealisateur(@RequestBody RealisateurDTO realisateur) throws ControllerException {
        try {
            realisateurService.update(realisateur);
            return ResponseEntity.status(HttpStatus.OK).body(realisateur);
        } catch (ServiceException e) {
            throw new ControllerException(e.getMessage());
        }
    }
}