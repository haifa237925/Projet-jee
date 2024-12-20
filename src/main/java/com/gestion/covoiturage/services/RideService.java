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

    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    public Ride getRideById(Long id) {
        return rideRepository.findById(id).orElse(null);
    }

    public Ride addRide(Ride ride) {
        return rideRepository.save(ride);
    }

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

    public void deleteRide(Long id) {
        rideRepository.deleteById(id);
    }
}
