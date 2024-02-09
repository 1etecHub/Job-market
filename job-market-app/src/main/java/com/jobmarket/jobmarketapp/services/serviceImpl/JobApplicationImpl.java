package com.jobmarket.jobmarketapp.services.serviceImpl;


import com.jobmarket.jobmarketapp.entities.jobpost.Applications;
import com.jobmarket.jobmarketapp.entities.jobpost.JobPost;
import com.jobmarket.jobmarketapp.entities.jobseeker.JobSeeker;
import com.jobmarket.jobmarketapp.exceptions.ApplicationException;
import com.jobmarket.jobmarketapp.payload.response.APIResponse;
import com.jobmarket.jobmarketapp.payload.response.jobpostresponse.JobApplicationResponse;
import com.jobmarket.jobmarketapp.repositories.JobApplicationRepository;
import com.jobmarket.jobmarketapp.repositories.JobPostRepository;
import com.jobmarket.jobmarketapp.repositories.JobSeekerRepository;
import com.jobmarket.jobmarketapp.security.JwtTokenProvider;
import com.jobmarket.jobmarketapp.services.JobApplicationService;
import com.jobmarket.jobmarketapp.utils.HelperClass;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class JobApplicationImpl implements JobApplicationService {


    private final HelperClass helperClass;
    private final JwtTokenProvider jwtTokenProvider;
    private final HttpServletRequest request;
    private final JobApplicationRepository applicationsRepository;
    private final ModelMapper modelMapper;
    private final JobSeekerRepository jobSeekerRepository;
    private final JobPostRepository jobPostRepository;

    private JobSeeker getJobSeeker() {
        String token = helperClass.getTokenFromHttpRequest(request);

        String email = jwtTokenProvider.getUserName(token);

        return jobSeekerRepository
                .findByEmail(email)
                .orElseThrow(() -> new ApplicationException("User does not exist with email " + email));
    }

    @Override
    public APIResponse<JobApplicationResponse> jobApplication(long jobPostId) {
        JobSeeker jobSeeker = getJobSeeker();

        Optional<JobPost> jobPostOptional = jobPostRepository.findById(jobPostId);

        if (jobPostOptional.isEmpty()) {
            throw new ApplicationException("Job Post not found");
        }
        Applications applications = Applications.builder()
                .jobPost(jobPostOptional.get())
                .jobSeeker(jobSeeker)
                .build();

        Applications savedApplication = applicationsRepository.save(applications);

        return  new APIResponse<>(
                "Application Successful",
                modelMapper.map(savedApplication, JobApplicationResponse.class)
                );

    }
}
