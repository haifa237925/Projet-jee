package com.gestion.covoiturage.services;

import com.gestion.covoiturage.entities.Ride;
import com.gestion.covoiturage.repositories.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideService {

    private final RideRepository rideRepository;

    @Autowired
    public RideService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    // Méthode pour récupérer tous les trajets
    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    // Méthode pour récupérer un trajet par son ID
    public Ride getRideById(Long id) {
        return rideRepository.findById(id).orElse(null);
    }

    // Méthode pour ajouter un nouveau trajet
    public Ride addRide(Ride ride) {
        return rideRepository.save(ride);
    }

    // Méthode pour mettre à jour un trajet
    public Ride updateRide(Long id, Ride rideDetails) {
        Ride ride = rideRepository.findById(id).orElse(null);
        if (ride != null) {
            ride.setPointDepart(rideDetails.getPointDepart());
            ride.setDestination(rideDetails.getDestination());
            ride.setDateHeure(rideDetails.getDateHeure());
            ride.setPlacesDisponibles(rideDetails.getPlacesDisponibles());
            ride.setPrixParPlace(rideDetails.getPrixParPlace());
            return rideRepository.save(ride);
        }
        return null;
    }

    // Méthode pour supprimer un trajet
    public void deleteRide(Long id) {
        rideRepository.deleteById(id);
    }
}
