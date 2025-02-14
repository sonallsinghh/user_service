package com.namma.user.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger user_id;

    @Column(nullable = false, unique = true)
    private String username; // Only username field

    private String status; // ACTIVE, INACTIVE, CANCELLED

    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt; // Automatically set at creation

    @Column(name = "updated_at")
    private Timestamp updatedAt; // Automatically updated on modification

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis()); // Set createdAt to current time
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis()); // Set updatedAt to current time
    }
}