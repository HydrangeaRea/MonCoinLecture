package com.example.MonCoinLecture.beans;

import jakarta.persistence.*;

@Entity
public class Avis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int ID;
    private String avancement;
    private int note;
    private String commentaire;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Utilisateurs utilisateur;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Livres livre;
    public Avis() {
    }


    public Avis(String avancement, int note, String commentaire, Utilisateurs utilisateur, Livres livre) {
        this.avancement = avancement;
        this.note = note;
        this.commentaire = commentaire;
        this.utilisateur = utilisateur;
        this.livre = livre;
    }

    @Override
    public String toString() {
        return "Avis{" +
                "ID=" + ID +
                ", avancement='" + avancement + '\'' +
                ", note=" + note +
                ", commentaire='" + commentaire + '\'' +
                ", Utilisateur=" + utilisateur +
                ", livre=" + livre +
                '}';
    }

    public int getID() {
        return ID;
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

    public void setID(int ID) {
        this.ID = ID;
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

    public Utilisateurs getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateurs utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Livres getLivre() {
        return livre;
    }

    public void setLivre(Livres livre) {
        this.livre = livre;
    }
}
