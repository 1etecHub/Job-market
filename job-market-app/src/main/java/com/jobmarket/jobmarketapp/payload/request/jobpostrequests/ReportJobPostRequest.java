package com.jobmarket.jobmarketapp.payload.request.jobpostrequests;


import com.jobmarket.jobmarketapp.entities.enums.ReportCat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportJobPostRequest {
    @NotNull(message = "required")
    private Long jobId;

    @NotBlank(message = "required")
    private String comment;

    @NotNull(message = "required")
    private ReportCat reportCategory;
}
