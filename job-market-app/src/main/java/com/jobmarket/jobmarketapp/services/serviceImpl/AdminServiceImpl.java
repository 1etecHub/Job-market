package com.jobmarket.jobmarketapp.services.serviceImpl;


import com.jobmarket.jobmarketapp.entities.employer.Employer;
import com.jobmarket.jobmarketapp.entities.jobseeker.JobSeeker;
import com.jobmarket.jobmarketapp.exceptions.ApplicationException;
import com.jobmarket.jobmarketapp.payload.response.APIResponse;
import com.jobmarket.jobmarketapp.payload.response.employerresponse.EmployerResponse;
import com.jobmarket.jobmarketapp.payload.response.employerresponse.EmployerResponsePage;
import com.jobmarket.jobmarketapp.payload.response.jsresponse.JobSeekerResponse;
import com.jobmarket.jobmarketapp.payload.response.jsresponse.JobSeekerResponsePage;
import com.jobmarket.jobmarketapp.repositories.EmployerRepository;
import com.jobmarket.jobmarketapp.repositories.JobSeekerRepository;
import com.jobmarket.jobmarketapp.services.AdminService;
import com.jobmarket.jobmarketapp.services.EmployerService;
import com.jobmarket.jobmarketapp.services.JobSeekerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final EmployerService employerService;
    private final JobSeekerService jobSeekerService;
    private final EmployerRepository employerRepository;
    private final JobSeekerRepository jobSeekerRepository;
    private final ModelMapper modelMapper;

    @Override
    public ResponseEntity<EmployerResponsePage> getAllEmployers(int pageNo, int pageSize, String sortBy, String sortDir) {
        // Delegate the call to EmployerService's getAllEmployers method
        return employerService.getAllEmployers(pageNo, pageSize, sortBy, sortDir);
    }

    @Override
    public ResponseEntity<APIResponse<EmployerResponse>> getEmployerById(Long employerId) {
        Optional<Employer> employerOptional = employerRepository.findById(employerId);
        if (employerOptional.isEmpty()) {
            throw new ApplicationException("Employer With ID" + employerId + "Does Not Exist");
        }
        Employer employer = employerOptional.get();
        EmployerResponse employerResponse = modelMapper.map(employer, EmployerResponse.class);
        return ResponseEntity.ok(new APIResponse<>("Search Successful", employerResponse));
    }

    @Override
    public ResponseEntity<APIResponse<JobSeekerResponsePage>> getAllJobSeekers(int pageNo, int pageSize, String sortBy, String sortDir) {
        return jobSeekerService.getAllJobSeekers(pageNo, pageSize, sortBy, sortDir);
    }
    @Override
    public ResponseEntity<APIResponse<JobSeekerResponse>> getJobSeekerById(Long jobSeekerId) {
        Optional<JobSeeker> jobSeekerOptional = jobSeekerRepository.findById(jobSeekerId);
        if (jobSeekerOptional.isEmpty()) {
            throw new ApplicationException("Job Seeker with ID " + jobSeekerId + " does not exist");
        }

        JobSeeker jobSeeker = jobSeekerOptional.get();
        JobSeekerResponse jobSeekerResponse = modelMapper.map(jobSeeker, JobSeekerResponse.class);

        return ResponseEntity.ok(new APIResponse<>("Job Seeker retrieved successfully", jobSeekerResponse));
    }

}
