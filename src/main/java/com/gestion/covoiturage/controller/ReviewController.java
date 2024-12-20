package com.gestion.covoiturage.controller;

import com.gestion.covoiturage.entities.Review;
import com.gestion.covoiturage.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // 1. Endpoint pour récupérer tous les avis
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    // 2. Endpoint pour ajouter un avis
    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        try {
            Review newReview = reviewService.addReview(review);
            return ResponseEntity.ok(newReview);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    // 3. Endpoint pour récupérer un avis spécifique
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Review review = reviewService.getReviewById(id);
        if (review != null) {
            return ResponseEntity.ok(review);
        }
        return ResponseEntity.notFound().build();
    }

    // 4. Endpoint pour supprimer un avis
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok("Avis supprimé avec succès.");
    }
}
