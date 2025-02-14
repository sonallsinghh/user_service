package com.namma.user.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "qr_tickets")
public class QRTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId; // Assuming ticketId is a UUID or similar

    @Column(nullable = false)
    private String userId; // Foreign key to users table

    @Column(nullable = false, unique = true)
    private String ticketNumber; // Unique ticket number

    @Column(nullable = false)
    private String status; // ACTIVE, INACTIVE, EXPIRED, CANCELLED
}
