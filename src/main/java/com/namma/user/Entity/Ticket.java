package com.namma.user.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId; // Assuming ticketId is a UUID or similar

    @Column(nullable = false)
    private String userId; // Foreign key to users table

    @Column(nullable = false)
    private String ticketType; // 'CARD' or 'QR'

    @Column(nullable = false)
    private String status; // ACTIVE, INACTIVE, CANCELLED

    // Additional fields can be added as needed
}