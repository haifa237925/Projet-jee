package com.gestion.covoiturage.controller;

import com.gestion.covoiturage.entities.Ride;
import com.gestion.covoiturage.services.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rides")
public class RideController {

    @Autowired
    private RideService rideService;

    // Récupérer tous les trajets
    @GetMapping
    public ResponseEntity<List<Ride>> getAllRides() {
        List<Ride> rides = rideService.getAllRides();
        return ResponseEntity.ok(rides);
    }

    // Ajouter un nouveau trajet
    @PostMapping
    public ResponseEntity<Ride> addRide(@RequestBody Ride ride) {
        if (ride.getConducteur() == null || ride.getConducteur().getId() == null) {
            return ResponseEntity.badRequest().body(null); // Si le conducteur est manquant
        }

        Ride newRide = rideService.addRide(ride);
        return ResponseEntity.ok(newRide);
    }

    // Récupérer un trajet spécifique par ID
    @GetMapping("/{id}")
    public ResponseEntity<Ride> getRideById(@PathVariable Long id) {
        Ride ride = rideService.getRideById(id);
        return ride != null ? ResponseEntity.ok(ride) : ResponseEntity.notFound().build();
    }

    // Supprimer un trajet par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRide(@PathVariable Long id) {
        rideService.deleteRide(id);
        return ResponseEntity.ok("Trajet supprimé avec succès.");
    }
}
