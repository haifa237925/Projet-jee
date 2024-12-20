package com.gestion.covoiturage.repositories;

import com.gestion.covoiturage.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Méthodes personnalisées si nécessaire
}
