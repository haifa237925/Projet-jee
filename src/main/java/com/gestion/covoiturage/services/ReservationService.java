package com.gestion.covoiturage.services;

import com.gestion.covoiturage.entities.Reservation;
import com.gestion.covoiturage.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // Méthode pour récupérer toutes les réservations
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    // Méthode pour récupérer une réservation par son ID
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    // Méthode pour ajouter une réservation
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    // Méthode pour supprimer une réservation
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}
