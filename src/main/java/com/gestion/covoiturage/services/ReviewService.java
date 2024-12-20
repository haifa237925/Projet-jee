package com.gestion.covoiturage.services;

import com.gestion.covoiturage.entities.Review;
import com.gestion.covoiturage.entities.User;
import com.gestion.covoiturage.entities.Ride;
import com.gestion.covoiturage.repositories.ReviewRepository;
import com.gestion.covoiturage.repositories.UserRepository;
import com.gestion.covoiturage.repositories.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RideRepository rideRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, UserRepository userRepository, RideRepository rideRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.rideRepository = rideRepository;
    }

    // Méthode pour récupérer tous les avis
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Méthode pour récupérer un avis par son ID
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    // Méthode pour ajouter un avis
    public Review addReview(Review review) {
        // Vérifier si l'utilisateur existe
        User utilisateur = userRepository.findById(review.getUtilisateur().getId()).orElse(null);
        if (utilisateur == null) {
            throw new IllegalArgumentException("Utilisateur non trouvé");
        }

        // Vérifier si le trajet existe
        Ride trajet = rideRepository.findById(review.getTrajet().getId()).orElse(null);
        if (trajet == null) {
            throw new IllegalArgumentException("Trajet non trouvé");
        }

        // Enregistrer l'avis
        review.setUtilisateur(utilisateur);
        review.setTrajet(trajet);
        return reviewRepository.save(review);
    }

    // Méthode pour supprimer un avis
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
