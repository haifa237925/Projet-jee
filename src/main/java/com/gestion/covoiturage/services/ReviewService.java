package com.gestion.covoiturage.services;

import com.gestion.covoiturage.entities.Review;
import com.gestion.covoiturage.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
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
        return reviewRepository.save(review);
    }

    // Méthode pour supprimer un avis
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
