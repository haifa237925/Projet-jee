package com.gestion.covoiturage.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations") // Table associée à cette entité
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


    @Column(nullable = false)
    private LocalDateTime dateReservation = LocalDateTime.now();

    @Enumerated(EnumType.STRING) // Statut de la réservation
    @Column(nullable = false)
    private StatutReservation statut;

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

    public LocalDateTime getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDateTime dateReservation) {
        this.dateReservation = dateReservation;
    }

    public StatutReservation getStatut() {
        return statut;
    }

    public void setStatut(StatutReservation statut) {
        this.statut = statut;
    }
}

enum StatutReservation {
    CONFIRMEE, EN_ATTENTE, ANNULEE
}
