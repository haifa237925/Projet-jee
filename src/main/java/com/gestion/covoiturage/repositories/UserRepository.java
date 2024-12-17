package com.gestion.covoiturage.repositories;

import com.gestion.covoiturage.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Tu peux ajouter des méthodes personnalisées si nécessaire
    User findByEmail(String email); // Exemple de méthode personnalisée
}
