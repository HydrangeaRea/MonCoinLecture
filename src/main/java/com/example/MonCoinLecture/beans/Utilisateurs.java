package com.example.MonCoinLecture.beans;

import jakarta.persistence.*;


import java.util.Date;

@Entity
public class Utilisateurs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int ID;
    private String pseudo = "";
    private String motDePasse = "";
    private String adresseMail = "";
    private String photo;
    private String auteurFavori = "";
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Livres livreFavori;
    private String description = "";
    private Date dateInscription;

    public Utilisateurs() {
    }

    public Utilisateurs(String pseudo, String motDePasse, String adresseMail) {
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.adresseMail = adresseMail;
    }

    public Utilisateurs(String pseudo, String motDePasse, String adresseMail, String photo, String auteurFavori, String description, Date dateInscription) {
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
        this.adresseMail = adresseMail;
        this.photo = photo;
        this.auteurFavori = auteurFavori;
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

    public String getPhoto() {
        return photo;
    }

    public String getAuteurFavori() {
        return auteurFavori;
    }

    public Livres getLivreFavori() {
        return livreFavori;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setAuteurFavori(String auteurFavori) {
        this.auteurFavori = auteurFavori;
    }

    public void setLivreFavori(Livres livreFavori) {
        this.livreFavori = livreFavori;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }
}
