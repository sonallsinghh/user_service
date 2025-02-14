package com.namma.user.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "travel_history")
public class TravelHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tripId; // Assuming tripId is a UUID or similar

    @Column(nullable = false)
    private String userId; // Foreign key to users table

    @Column(nullable = false)
    private String ticketId; // Foreign key to tickets table

    @Column(nullable = false)
    private String sourceStation; // Source station name

    @Column(nullable = false)
    private String destinationStation; // Destination station name

    @Column(nullable = false)
    private Timestamp checkInTime; // Check-in timestamp

    private Timestamp checkOutTime; // Check-out timestamp

    private BigDecimal fare; // Fare for the trip
}
