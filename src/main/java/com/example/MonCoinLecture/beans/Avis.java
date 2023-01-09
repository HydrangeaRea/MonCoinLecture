package com.example.MonCoinLecture.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Avis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int ID;
    private int id_utilisateur;
    private int id_livre;
    private String avancement;
    private int note;
    private String commentaire;

    private int id_livre_suggestion;

    public Avis() {
    }

    public Avis(int id_utilisateur, int id_livre, String avancement, int note, String commentaire, int id_livre_suggestion) {
        this.id_utilisateur = id_utilisateur;
        this.id_livre = id_livre;
        this.avancement = avancement;
        this.note = note;
        this.commentaire = commentaire;
        this.id_livre_suggestion = id_livre_suggestion;
    }

    @Override
    public String toString() {
        return "Avis{" +
                "ID=" + ID +
                ", id_utilisateur=" + id_utilisateur +
                ", id_livre=" + id_livre +
                ", avancement='" + avancement + '\'' +
                ", note=" + note +
                ", commentaire='" + commentaire + '\'' +
                ", id_livre_suggestion=" + id_livre_suggestion +
                '}';
    }

    public int getID() {
        return ID;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public int getId_livre() {
        return id_livre;
    }

    public String getAvancement() {
        return avancement;
    }

    public int getNote() {
        return note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public int getId_livre_suggestion() {
        return id_livre_suggestion;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public void setId_livre(int id_livre) {
        this.id_livre = id_livre;
    }

    public void setAvancement(String avancement) {
        this.avancement = avancement;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public void setId_livre_suggestion(int id_livre_suggestion) {
        this.id_livre_suggestion = id_livre_suggestion;
    }
}
