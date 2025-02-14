package com.namma.user.Service;

import com.namma.user.DTO.UserDTO;
import com.namma.user.Entity.User;
import com.namma.user.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigInteger;

@Service
public class UserProfileService {

    @Autowired
    private UserRepository userRepository;

    public UserDTO getUserProfile(BigInteger userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserDTO dto = new UserDTO();
        dto.setUserId(String.valueOf(user.getUser_id()));
        dto.setUsername(user.getUsername());
        dto.setStatus(user.getStatus());
        return dto;
    }

    public void updateUserStatus(Long userId, String status) {
        User user = userRepository.findById(BigInteger.valueOf(userId))
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setStatus(status);
        userRepository.save(user);
    }
}
