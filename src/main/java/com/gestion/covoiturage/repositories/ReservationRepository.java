package com.gestion.covoiturage.repositories;

import com.gestion.covoiturage.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // Tu peux ajouter des méthodes personnalisées si nécessaire
}
