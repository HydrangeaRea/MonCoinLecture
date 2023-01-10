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

    private int id_livre_suggestion;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Utilisateurs utilisateur = new Utilisateurs();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Livres livre = new Livres();
    public Avis() {
    }

    public Avis(String avancement, int note, String commentaire, int id_livre_suggestion, Utilisateurs utilisateur, Livres livre) {
        this.avancement = avancement;
        this.note = note;
        this.commentaire = commentaire;
        this.id_livre_suggestion = id_livre_suggestion;
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
                ", id_livre_suggestion=" + id_livre_suggestion +
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

    public int getId_livre_suggestion() {
        return id_livre_suggestion;
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

    public void setId_livre_suggestion(int id_livre_suggestion) {
        this.id_livre_suggestion = id_livre_suggestion;
    }

    public Utilisateurs getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateurs utilisateur) {
        utilisateur = utilisateur;
    }

    public Livres getLivre() {
        return livre;
    }

    public void setLivre(Livres livre) {
        this.livre = livre;
    }
}
