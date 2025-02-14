package com.namma.user.Service;

import com.namma.user.DTO.TravelHistoryDTO;
import com.namma.user.Entity.TravelHistory;
import com.namma.user.Repository.TravelHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TravelHistoryService {

    @Autowired
    private TravelHistoryRepository travelHistoryRepository;

    public List<TravelHistoryDTO> getTravelHistory(String userId) {
        List<TravelHistory> travelHistories = travelHistoryRepository
                .findTop10ByUserIdOrderByCheckInTimeDesc(userId);

        return travelHistories.stream().map(th -> {
            TravelHistoryDTO dto = new TravelHistoryDTO();
            dto.setTripId(String.valueOf(th.getTripId()));
            dto.setUserId(th.getUserId());
            dto.setTicketId(th.getTicketId());
            dto.setSourceStation(th.getSourceStation());
            dto.setDestinationStation(th.getDestinationStation());
            dto.setCheckInTime(th.getCheckInTime());
            dto.setCheckOutTime(th.getCheckOutTime());
            dto.setFare(th.getFare());
            return dto;
        }).collect(Collectors.toList());
    }
}
