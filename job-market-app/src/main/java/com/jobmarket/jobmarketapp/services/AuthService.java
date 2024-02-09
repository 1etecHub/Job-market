package com.jobmarket.jobmarketapp.services;


import com.jobmarket.jobmarketapp.payload.request.adminrequest.AdminSignup;
import com.jobmarket.jobmarketapp.payload.request.authrequests.ForgotPasswordResetRequest;
import com.jobmarket.jobmarketapp.payload.request.authrequests.LoginRequest;
import com.jobmarket.jobmarketapp.payload.request.employerreqests.EmployerSignup;
import com.jobmarket.jobmarketapp.payload.request.jsrequests.JobSeekerSignup;
import com.jobmarket.jobmarketapp.payload.response.APIResponse;
import com.jobmarket.jobmarketapp.payload.response.JwtAuthResponse;
import com.jobmarket.jobmarketapp.payload.response.adminresponse.AdminSignupResponse;
import com.jobmarket.jobmarketapp.payload.response.employerresponse.EmployerSignupResponse;
import com.jobmarket.jobmarketapp.payload.response.jsresponse.JobSeekerSignupResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<APIResponse<JobSeekerSignupResponse>> registerJobSeeker(JobSeekerSignup jobSeekerSignup);
    ResponseEntity<APIResponse<EmployerSignupResponse>> registerEmployer(EmployerSignup employerSignup);

    ResponseEntity<APIResponse<AdminSignupResponse>> registerAdmin(AdminSignup adminSignup);

    ResponseEntity<APIResponse<JwtAuthResponse>> login(LoginRequest loginRequest);
    void logout();

    ResponseEntity<APIResponse<String>> resendVerificationEmail(LoginRequest loginRequest);

    ResponseEntity<APIResponse<String>> forgotPassword(String email);
    ResponseEntity<APIResponse<String>> validateToken(String receivedToken);
    ResponseEntity<APIResponse<String>> resetForgotPassword(ForgotPasswordResetRequest forgotPasswordResetRequest);
}
