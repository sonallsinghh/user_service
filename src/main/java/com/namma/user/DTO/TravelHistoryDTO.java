package com.namma.user.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
public class TravelHistoryDTO {
    private String tripId;
    private String userId;
    private String ticketId;
    private String sourceStation;
    private String destinationStation;
    private Timestamp checkInTime;
    private Timestamp checkOutTime;
    private BigDecimal fare;
}
