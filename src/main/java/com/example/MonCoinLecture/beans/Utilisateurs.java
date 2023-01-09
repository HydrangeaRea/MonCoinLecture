package com.example.MonCoinLecture.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.awt.image.BufferedImage;
import java.util.Date;

@Entity
public class Utilisateurs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int ID;
    private String pseudo = "";
    private String motDePasse = "";
    private String adresseMail = "";
    private BufferedImage photo;
    private String auteurFavori = "";
    private String livreFavori = "";
    private String description = "";
    private Date dateInscription;

    public Utilisateurs() {
    }

    public Utilisateurs(String pseudo, String motDePasse, String adresseMail, BufferedImage photo, String auteurFavori, String livreFavori, String description, Date dateInscription) {
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.adresseMail = adresseMail;
        this.photo = photo;
        this.auteurFavori = auteurFavori;
        this.livreFavori = livreFavori;
        this.description = description;
        this.dateInscription = dateInscription;
    }

    @Override
    public String toString() {
        return "Utilisateurs{" +
                "ID=" + ID +
                ", pseudo='" + pseudo + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", adresseMail='" + adresseMail + '\'' +
                ", photo=" + photo +
                ", auteurFavori='" + auteurFavori + '\'' +
                ", livreFavori='" + livreFavori + '\'' +
                ", description='" + description + '\'' +
                ", dateInscription=" + dateInscription +
                '}';
    }

    public int getID() {
        return ID;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public BufferedImage getPhoto() {
        return photo;
    }

    public String getAuteurFavori() {
        return auteurFavori;
    }

    public String getLivreFavori() {
        return livreFavori;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateInscription() {
        return dateInscription;
    }


}
