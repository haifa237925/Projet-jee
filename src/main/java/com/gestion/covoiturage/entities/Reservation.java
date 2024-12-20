package com.gestion.covoiturage.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "passager_id", nullable = false)
    private User passager;

    @ManyToOne
    @JoinColumn(name = "trajet_id", nullable = false)
    private Ride trajet;

    // Getters et setters
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public User getPassager() {
        return passager;
    }

    public void setPassager(User passager) {
        this.passager = passager;
    }

    public Ride getTrajet() {
        return trajet;
    }

    public void setTrajet(Ride trajet) {
        this.trajet = trajet;
    }
}
