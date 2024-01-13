package com.jobmarket.jobmarketapp.services;


import com.jobmarket.jobmarketapp.payload.response.APIResponse;
import com.jobmarket.jobmarketapp.payload.response.employerresponse.EmployerResponse;
import com.jobmarket.jobmarketapp.payload.response.employerresponse.EmployerResponsePage;
import com.jobmarket.jobmarketapp.payload.response.jsresponse.JobSeekerResponse;
import com.jobmarket.jobmarketapp.payload.response.jsresponse.JobSeekerResponsePage;
import org.springframework.http.ResponseEntity;

public interface AdminService {
    ResponseEntity<EmployerResponsePage> getAllEmployers(int pageNo, int pageSize, String sortBy, String sortDir);
    ResponseEntity<APIResponse<EmployerResponse>> getEmployerById(Long employerId);

    ResponseEntity<APIResponse<JobSeekerResponsePage>> getAllJobSeekers(int pageNo, int pageSize, String sortBy, String sortDir);
    ResponseEntity<APIResponse<JobSeekerResponse>> getJobSeekerById(Long jobSeekerId);
}
