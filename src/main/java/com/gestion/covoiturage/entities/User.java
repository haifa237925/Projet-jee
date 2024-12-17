package com.gestion.covoiturage.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity // Indique que cette classe est une entité JPA
@Table(name = "users") // Associe cette entité à la table "users"
public class User {

    @Id // Identifie la clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrémentation
    private Long id;

    @Column(nullable = false, length = 50)
    private String nom;

    @Column(nullable = false, length = 50)
    private String prenom;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String motDePasse;

    @Enumerated(EnumType.STRING) // Permet de stocker l'énumération sous forme de texte
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private LocalDateTime dateInscription = LocalDateTime.now();

    // Getters et setters (générés automatiquement par IntelliJ ou Lombok)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDateTime dateInscription) {
        this.dateInscription = dateInscription;
    }
}

enum Role {
    Conducteur, Passager
}
