package com.ensta.myfilmlist.service;

import java.util.List;

import com.ensta.myfilmlist.dao.RealisateurDAO;
import com.ensta.myfilmlist.dto.RealisateurDTO;
import com.ensta.myfilmlist.exception.DaoException;
import com.ensta.myfilmlist.exception.ServiceException;
import com.ensta.myfilmlist.mapper.RealisateurMapper;
import com.ensta.myfilmlist.model.Realisateur;
import com.ensta.myfilmlist.dto.FilmDTO;

import org.springframework.stereotype.Service;

@Service
public class RealisateurService {

    private RealisateurDAO realisateurDAO;

    public RealisateurService(RealisateurDAO realisateurDAO) {
        this.realisateurDAO = realisateurDAO;
    }

    public List<RealisateurDTO> findAll() throws ServiceException {
        List<Realisateur> listRealisateurModel;
        try {
            listRealisateurModel = RealisateurMapper.listRealisateurPojoToListRealisateur(realisateurDAO.findAll());
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
        return RealisateurMapper.listRealisateurToListRealisateurDTO(listRealisateurModel);
    }

    public RealisateurDTO findById(long id) throws ServiceException {
        Realisateur realisateur;
        try {
            realisateur = RealisateurMapper.realisateurPojoToRealisateur(realisateurDAO.findById(id));
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());   
        }
        return RealisateurMapper.realisateurToRealisateurDTO(realisateur);
    }

    public void create(RealisateurDTO realisateur) throws ServiceException {
        try {
            realisateurDAO.create(RealisateurMapper.realisateurRealisateurToPojo(RealisateurMapper.realisateurDTOToRealisateur(realisateur)));
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void update(RealisateurDTO realisateur) throws ServiceException {
        try {
            realisateurDAO.update(RealisateurMapper.realisateurRealisateurToPojo(RealisateurMapper.realisateurDTOToRealisateur(realisateur)));
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public void deleteOne(long realisateurId) throws ServiceException {
        try {
            realisateurDAO.deleteOne(realisateurId);
        } catch (DaoException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}