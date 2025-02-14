package com.namma.user.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
public class MetroCardDTO {
    private String cardId;
    private String userId;
    private BigDecimal balance;
    private String status; // ACTIVE, INACTIVE, CANCELLED
    private Timestamp issueDate;
    private Timestamp expiryDate;
}
