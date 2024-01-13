package com.jobmarket.jobmarketapp.payload.response.authresponse;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    Long id;

    String email;

}
