package com.ensta.myfilmlist.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ensta.myfilmlist.dto.RealisateurDTO;
import com.ensta.myfilmlist.model.Realisateur;
import com.ensta.myfilmlist.pojo.RealisateurPojo;

public class RealisateurMapper {

    public static RealisateurDTO realisateurToRealisateurDTO(Realisateur realisateur){
        return new RealisateurDTO(realisateur.getId(), realisateur.getPrenom(), realisateur.getNom(), realisateur.getNaissance());
    }

    public static List<RealisateurDTO> listRealisateurToListRealisateurDTO(List<Realisateur> listRealisateur){
        List<RealisateurDTO> listRealisateurDTO = new ArrayList<>();
        for (Realisateur realisateur : listRealisateur ){
            listRealisateurDTO.add(realisateurToRealisateurDTO(realisateur));
        }
        return listRealisateurDTO;
    }

    public static Realisateur realisateurPojoToRealisateur(RealisateurPojo realisateur){
        return new Realisateur(realisateur.getId(), realisateur.getPrenom(), realisateur.getNom(), realisateur.getNaissance());
    }

    public static List<Realisateur> listRealisateurPojoToListRealisateur(List<RealisateurPojo> listRealisateur){
        List<Realisateur> listRealisateurDTO = new ArrayList<>();
        for (RealisateurPojo realisateur : listRealisateur ){
            listRealisateurDTO.add(realisateurPojoToRealisateur(realisateur));
        }
        return listRealisateurDTO;
    }
    
    public static Realisateur realisateurDTOToRealisateur(RealisateurDTO realisateur) {
        return new Realisateur(realisateur.getId(), realisateur.getPrenom(), realisateur.getNom(), realisateur.getNaissance());
    }

    public static RealisateurPojo realisateurRealisateurToPojo(Realisateur realisateur) {
        return new RealisateurPojo(realisateur.getId(), realisateur.getPrenom(), realisateur.getNom(), realisateur.getNaissance());
    }
}