package com.jobmarket.jobmarketapp.payload.response.employerresponse;

import com.swiftselect.domain.enums.CompanyType;
import com.swiftselect.domain.enums.Industry;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployerSignupResponse {
    Long id;
    String email;
    String firstName;
    Industry industry;
    String companyName;
    CompanyType companyType;
}
