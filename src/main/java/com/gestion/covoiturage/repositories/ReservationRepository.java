package com.gestion.covoiturage.repositories;

import com.gestion.covoiturage.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Ajouter des méthodes personnalisées si nécessaire
}
