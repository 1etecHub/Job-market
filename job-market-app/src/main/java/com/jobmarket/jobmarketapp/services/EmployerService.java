package com.jobmarket.jobmarketapp.services;

import com.jobmarket.jobmarketapp.entities.employer.Employer;
import com.jobmarket.jobmarketapp.payload.request.authrequests.ResetPasswordRequest;
import com.jobmarket.jobmarketapp.payload.request.employerreqests.EmployerProfileContactInfoRequest;
import com.jobmarket.jobmarketapp.payload.request.employerreqests.EmployerUpdateProfileRequest;
import com.jobmarket.jobmarketapp.payload.response.APIResponse;
import com.jobmarket.jobmarketapp.payload.response.employerresponse.EmployerResponsePage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

public interface EmployerService {
    Employer getEmployer();
    ResponseEntity<APIResponse<String>> resetPassword(HttpServletRequest request, ResetPasswordRequest resetPasswordRequest);
    ResponseEntity<APIResponse<String>> updateProfileCompanyInfo(EmployerUpdateProfileRequest updateProfileRequest);
    ResponseEntity<APIResponse<String>> updateProfileContactInfo(EmployerProfileContactInfoRequest updateProfileRequest);
    ResponseEntity<APIResponse<String>> deleteJobPost(String email, Long postId);
    ResponseEntity<EmployerResponsePage> getAllEmployers(int pageNo, int pageSize, String sortBy, String sortDir);
}
