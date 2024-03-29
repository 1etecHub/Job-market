package com.jobmarket.jobmarketapp.payload.request.jsrequests.jsprofilerequests;


import com.jobmarket.jobmarketapp.entities.enums.YearsOfExp;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SkillsRequest {
    @Size(min = 2, max = 25)
    @NotBlank(message = "required")
    String skill;

    @NotNull(message = "required")
    YearsOfExp yearsOfExperience;
}
