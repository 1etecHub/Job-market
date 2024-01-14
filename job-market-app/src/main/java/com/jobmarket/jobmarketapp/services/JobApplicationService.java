package com.jobmarket.jobmarketapp.services;


import com.jobmarket.jobmarketapp.payload.response.APIResponse;
import com.jobmarket.jobmarketapp.payload.response.jobpostresponse.JobApplicationResponse;

public interface JobApplicationService {
    APIResponse<JobApplicationResponse> jobApplication(long jobPostId);

}
