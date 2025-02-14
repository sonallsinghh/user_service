//package com.namma.user.Service;
//
//import com.namma.user.Entity.MetroCard;
//import com.namma.user.Entity.TravelHistory;
//import com.namma.user.Entity.User;
//import com.namma.user.DTO.MetroCardDTO;
//import com.namma.user.DTO.TravelHistoryDTO;
//import com.namma.user.DTO.UserDTO;
//import com.namma.user.Repository.MetroCardRepository;
//import com.namma.user.Repository.TravelHistoryRepository;
//import com.namma.user.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.math.BigDecimal;
//import java.math.BigInteger;
//import java.sql.Timestamp;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private MetroCardRepository metroCardRepository;
//
//    @Autowired
//    private TravelHistoryRepository travelHistoryRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//      // Update with your actual service name & URL
//
//
//
//    public MetroCardDTO buyMetroCard(String userId, BigDecimal initialBalance) {
//        MetroCard metroCard = new MetroCard();
//        metroCard.setUserId(userId);
//        metroCard.setBalance(initialBalance);
//        metroCard.setStatus("ACTIVE");
//        metroCard = metroCardRepository.save(metroCard);
//        MetroCardDTO dto = new MetroCardDTO();
//        dto.setCardId(String.valueOf(metroCard.getCardId()));
//        dto.setUserId(metroCard.getUserId());
//        dto.setBalance(metroCard.getBalance());
//        dto.setStatus(metroCard.getStatus());
//        return dto;
//    }
//
//    public List<TravelHistoryDTO> getTravelHistory(String userId) {
//        List<TravelHistory> travelHistories = travelHistoryRepository.findTop10ByUserIdOrderByCheckInTimeDesc(userId);
//        return travelHistories.stream().map(th -> {
//            TravelHistoryDTO dto = new TravelHistoryDTO();
//            dto.setTripId(String.valueOf(th.getTripId()));
//            dto.setUserId(th.getUserId());
//            dto.setTicketId(th.getTicketId());
//            dto.setSourceStation(th.getSourceStation());
//            dto.setDestinationStation(th.getDestinationStation());
//            dto.setCheckInTime(th.getCheckInTime());
//            dto.setCheckOutTime(th.getCheckOutTime());
//            dto.setFare(th.getFare());
//            return dto;
//        }).collect(Collectors.toList());
//    }
//
//    public String cancelPass(Long cardId) {
//        MetroCard metroCard = metroCardRepository.findById(cardId).orElseThrow(() -> new RuntimeException("Metro card not found"));
//        if ("ACTIVE".equals(metroCard.getStatus())) {
//            metroCard.setStatus("CANCELLED");
//            metroCardRepository.save(metroCard);
//            return "Metro card cancelled successfully.";
//        }
//        return "Metro card cannot be cancelled.";
//    }
//
//    public UserDTO getUserProfile(BigInteger userId) {
//        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User  not found"));
//        UserDTO dto = new UserDTO();
//        dto.setUserId(String.valueOf(user.getUser_id()));
//        dto.setUsername(user.getUsername());
//        dto.setStatus(user.getStatus());
//        return dto;
//    }
//
//    public void updateUserStatus(Long userId, String status) {
//        User user = userRepository.findById(BigInteger.valueOf(userId))
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        user.setStatus(status);
//        userRepository.save(user);
//    }
//}