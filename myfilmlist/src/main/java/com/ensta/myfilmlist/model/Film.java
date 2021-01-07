package com.ensta.myfilmlist.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Film {
    private long id;
    private String titre;
    private int duration;
    private long id_realisateur;
    private String nom_realisateur;
    private long id_genre;

    public String getTitre() {
        return titre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public long getRealisateur() {
        return id_realisateur;
    }

    public void setRealisateur(long id_realisateur) {
        this.id_realisateur = id_realisateur;
    }

    public String getNomRealisateur() {
        return nom_realisateur;
    }

    public void setNomRealisateur(String nom_realisateur) {
        this.nom_realisateur = nom_realisateur;
    }

    public long getGenre() {
        return id_genre;
    }

    public void setGenre(long id_genre) {
        this.id_genre = id_genre;
    }

    public Film(String titre, int duration, long id_realisateur, String nom_realisateur, long id_genre) {
        this.titre = titre;
        this.duration = duration;
        this.id_realisateur = id_realisateur;
        this.nom_realisateur = nom_realisateur;
        this.id_genre = id_genre;
    }

    public Film(long id, String titre, int duration, long id_realisateur, String nom_realisateur, long id_genre) {
        this.id = id;
        this.titre = titre;
        this.duration = duration;
        this.id_realisateur = id_realisateur;
        this.nom_realisateur = nom_realisateur;
        this.id_genre = id_genre;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }    
}