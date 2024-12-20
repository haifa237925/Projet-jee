package com.gestion.covoiturage.services;

import com.gestion.covoiturage.entities.Reservation;
import com.gestion.covoiturage.entities.Ride;
import com.gestion.covoiturage.entities.User;
import com.gestion.covoiturage.repositories.ReservationRepository;
import com.gestion.covoiturage.repositories.RideRepository;
import com.gestion.covoiturage.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private UserRepository userRepository;

    // Récupérer toutes les réservations
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    // Ajouter une réservation
    public Reservation addReservation(Reservation reservation) {
        // Vérifier si l'utilisateur et le trajet existent
        User user = userRepository.findById(reservation.getPassager().getId())
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur invalide"));
        Ride ride = rideRepository.findById(reservation.getTrajet().getId())
                .orElseThrow(() -> new IllegalArgumentException("Trajet invalide"));

        // Vérifier si des places sont disponibles
        if (ride.getPlacesDisponibles() <= 0) {
            throw new IllegalArgumentException("Aucune place disponible pour ce trajet.");
        }

        // Réduire le nombre de places disponibles
        ride.setPlacesDisponibles(ride.getPlacesDisponibles() - 1);
        rideRepository.save(ride);

        // Sauvegarder la réservation
        reservation.setPassager(user);
        reservation.setTrajet(ride);
        return reservationRepository.save(reservation);
    }

    // Récupérer une réservation par ID
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    // Supprimer une réservation
    public boolean deleteReservation(Long id) {
        if (reservationRepository.existsById(id)) {
            reservationRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
