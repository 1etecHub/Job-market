package com.jobmarket.jobmarketapp.payload.request.jsrequests.jsprofilerequests;


import com.jobmarket.jobmarketapp.entities.enums.Industry;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobPreferenceRequest {
    @NotNull
    Industry industry;
}
