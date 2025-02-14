package com.namma.user.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private String userId;
    private String username;
    private String status; // ACTIVE, INACTIVE, CANCELLED
}
