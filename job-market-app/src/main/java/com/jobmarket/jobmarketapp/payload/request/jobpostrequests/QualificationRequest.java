package com.jobmarket.jobmarketapp.payload.request.jobpostrequests;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QualificationRequest {
    @NotBlank(message = "required")
    private String qualificationDetails;
}
