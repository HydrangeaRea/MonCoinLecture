package com.example.MonCoinLecture.beans;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Livres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int ID;
    private String titre = "";
    private String titreSerie = "";
    private String volume = "";
    private String avancement = "";
    private String auteur = "";
    private String illustrateur = "";
    private String editeur = "";
    private String genre = "";
    private String type = "";
    private Date datePubli;
    private String couverture;
    @Column(columnDefinition = "TEXT")
    private String resume = "";

    public Livres() {
    }

    public Livres(String titre, String titreSerie, String volume, String avancement, String auteur, String illustrateur, String editeur, String genre, String type, Date datePubli, String couverture, String resume) {
        this.titre = titre;
        this.titreSerie = titreSerie;
        this.volume = volume;
        this.avancement = avancement;
        this.auteur = auteur;
        this.illustrateur = illustrateur;
        this.editeur = editeur;
        this.genre = genre;
        this.type = type;
        this.datePubli = datePubli;
        this.couverture = couverture;
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "Livres{" +
                "ID=" + ID +
                ", titre='" + titre + '\'' +
                ", titreSerie='" + titreSerie + '\'' +
                ", volume='" + volume + '\'' +
                ", avancement='" + avancement + '\'' +
                ", auteur='" + auteur + '\'' +
                ", illustrateur='" + illustrateur + '\'' +
                ", editeur='" + editeur + '\'' +
                ", genre='" + genre + '\'' +
                ", type='" + type + '\'' +
                ", datePubli=" + datePubli +
                ", couverture=" + couverture +
                ", resume='" + resume + '\'' +
                '}';
    }

    public int getID() {
        return ID;
    }

    public String getTitre() {
        return titre;
    }

    public String getTitreSerie() {
        return titreSerie;
    }

    public String getVolume() {
        return volume;
    }

    public String getAvancement() {
        return avancement;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getIllustrateur() {
        return illustrateur;
    }

    public String getEditeur() {
        return editeur;
    }

    public String getGenre() {
        return genre;
    }

    public String getType() {
        return type;
    }

    public Date getDatePubli() {
        return datePubli;
    }

    public String getCouverture() {
        return couverture;
    }

    public String getResume() {
        return resume;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setTitreSerie(String titreSerie) {
        this.titreSerie = titreSerie;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setAvancement(String avancement) {
        this.avancement = avancement;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setIllustrateur(String illustrateur) {
        this.illustrateur = illustrateur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDatePublication(Date datePubli) {
        this.datePubli = datePubli;
    }

    public void setCouverture(String couverture) {
        this.couverture = couverture;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}

