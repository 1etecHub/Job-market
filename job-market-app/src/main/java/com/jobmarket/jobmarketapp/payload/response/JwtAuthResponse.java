package com.jobmarket.jobmarketapp.payload.response;


import com.jobmarket.jobmarketapp.entities.enums.Gender;
import com.jobmarket.jobmarketapp.entities.enums.Role;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JwtAuthResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String profilePicture;
    private String email;
    private Gender gender;
    private Role role;
    private String accessToken;
    private String refreshToken;
    private String tokenType = "Bearer";
}
