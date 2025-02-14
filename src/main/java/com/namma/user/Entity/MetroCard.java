package com.namma.user.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "metro_cards")
public class MetroCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId; // Assuming cardId is a UUID or similar

    @Column(nullable = false)
    private String userId; // Foreign key to users table

    @Column(nullable = false)
    private BigDecimal balance; // Balance for the metro card

    @Column(nullable = false)
    private String status; // ACTIVE, INACTIVE, CANCELLED

}
