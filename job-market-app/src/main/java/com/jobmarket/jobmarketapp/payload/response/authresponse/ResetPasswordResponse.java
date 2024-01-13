package com.jobmarket.jobmarketapp.payload.response.authresponse;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResetPasswordResponse {

    private Long id;
    private String firstName;
}
