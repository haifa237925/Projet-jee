package com.gestion.covoiturage.repositories;

import com.gestion.covoiturage.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Long> {
    // Ajouter des méthodes personnalisées pour des recherches spécifiques
}
