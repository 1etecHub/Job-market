package com.jobmarket.jobmarketapp.payload.response.jobpostresponse;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QualificationResponse {
    private Long id;
    private String qualifications;
}
