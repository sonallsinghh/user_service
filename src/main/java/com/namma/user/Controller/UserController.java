package com.namma.user.Controller;

import com.namma.user.DTO.MetroCardDTO;
import com.namma.user.DTO.TravelHistoryDTO;
import com.namma.user.DTO.UserDTO;
import com.namma.user.Service.MetroCardService;
import com.namma.user.Service.TravelHistoryService;
import com.namma.user.Service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private MetroCardService metroCardService;

    @Autowired
    private TravelHistoryService travelHistoryService;

    @Autowired
    private UserProfileService userProfileService;

    // Buy a new Metro Card
    @PostMapping("/{userId}/metro-card")
    public ResponseEntity<MetroCardDTO> buyMetroCard(
            @PathVariable String userId, @RequestParam BigDecimal initialBalance) {
        MetroCardDTO metroCardDTO = metroCardService.buyMetroCard(userId, initialBalance);
        return ResponseEntity.ok(metroCardDTO);
    }

    // Get Travel History for a user
    @GetMapping("/{userId}/travel-history")
    public ResponseEntity<List<TravelHistoryDTO>> getTravelHistory(@PathVariable String userId) {
        List<TravelHistoryDTO> travelHistory = travelHistoryService.getTravelHistory(userId);
        return ResponseEntity.ok(travelHistory);
    }

    // Cancel Metro Card
    @DeleteMapping("/metro-card/{cardId}")
    public ResponseEntity<String> cancelPass(@PathVariable Long cardId) {
        String response = metroCardService.cancelPass(cardId);
        return ResponseEntity.ok(response);
    }

    // Get User Profile
    @GetMapping("/profile/{userId}")
    public ResponseEntity<UserDTO> getUserProfile(@PathVariable BigInteger userId) {
        UserDTO userProfile = userProfileService.getUserProfile(userId);
        return ResponseEntity.ok(userProfile);
    }

    // Update User Status
    @PutMapping("/update-status")
    public ResponseEntity<String> updateStatus(@RequestParam Long userId, @RequestParam String status) {
        userProfileService.updateUserStatus(userId, status);
        return ResponseEntity.ok("User status updated to " + status);
    }
}
