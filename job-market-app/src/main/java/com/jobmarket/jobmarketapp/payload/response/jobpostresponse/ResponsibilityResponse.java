package com.jobmarket.jobmarketapp.payload.response.jobpostresponse;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponsibilityResponse {
    private Long id;
    private String responsibility;
}
