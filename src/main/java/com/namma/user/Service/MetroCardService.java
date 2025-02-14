package com.namma.user.Service;

import com.namma.user.DTO.MetroCardDTO;
import com.namma.user.Entity.MetroCard;
import com.namma.user.Repository.MetroCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class MetroCardService {

    @Autowired
    private MetroCardRepository metroCardRepository;

    public MetroCardDTO buyMetroCard(String userId, BigDecimal initialBalance) {
        MetroCard metroCard = new MetroCard();
        metroCard.setUserId(userId);
        metroCard.setBalance(initialBalance);
        metroCard.setStatus("ACTIVE");
        metroCard = metroCardRepository.save(metroCard);

        MetroCardDTO dto = new MetroCardDTO();
        dto.setCardId(String.valueOf(metroCard.getCardId()));
        dto.setUserId(metroCard.getUserId());
        dto.setBalance(metroCard.getBalance());
        dto.setStatus(metroCard.getStatus());
        return dto;
    }

    public String cancelPass(Long cardId) {
        MetroCard metroCard = metroCardRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Metro card not found"));

        if ("ACTIVE".equals(metroCard.getStatus())) {
            metroCard.setStatus("CANCELLED");
            metroCardRepository.save(metroCard);
            return "Metro card cancelled successfully.";
        }
        return "Metro card cannot be cancelled.";
    }
}
