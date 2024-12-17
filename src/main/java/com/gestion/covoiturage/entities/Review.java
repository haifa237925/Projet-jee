package com.gestion.covoiturage.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews") // Table associée à cette entité
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private User utilisateur;

    @ManyToOne
    @JoinColumn(name = "trajet_id", nullable = false)
    private Ride trajet;



    @Column(nullable = false)
    private int note; // Note entre 1 et 5

    @Column(length = 500)
    private String commentaire; // Commentaire sur le trajet

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(User utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Ride getTrajet() {
        return trajet;
    }

    public void setTrajet(Ride trajet) {
        this.trajet = trajet;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
