package com.ensta.myfilmlist.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Realisateur {
    private long id;
    private String nom;
    private String prenom;
    private String naissance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNaissance() {
        return naissance;
    }

    public void setNaissance(String naissance) {
        this.naissance = naissance;
    }

    public Realisateur(String prenom, String nom, String naissance) {
        this.prenom = prenom;
        this.nom = nom;
        this.naissance = naissance;
    }

    public Realisateur(long id, String prenom, String nom, String naissance) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.naissance = naissance;
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