package com.jobmarket.jobmarketapp.services;


import com.jobmarket.jobmarketapp.entities.enums.ExperienceLevel;
import com.jobmarket.jobmarketapp.entities.enums.JobType;
import com.jobmarket.jobmarketapp.entities.enums.ReportCat;
import com.jobmarket.jobmarketapp.entities.jobpost.JobPost;
import com.jobmarket.jobmarketapp.payload.request.jobpostrequests.JobPostRequest;
import com.jobmarket.jobmarketapp.payload.response.APIResponse;
import com.jobmarket.jobmarketapp.payload.response.PostResponsePage;
import com.jobmarket.jobmarketapp.payload.response.jobpostresponse.JobPostResponse;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JobPostService {
    ResponseEntity<APIResponse<JobPostResponse>> createJobPost(JobPostRequest jobPostRequest);

    ResponseEntity<APIResponse<Slice<JobPostResponse>>> getJobPostByExperienceLevel(ExperienceLevel experienceLevel, int pageNo, int pageSize, String sortBy, String sortDir);

    ResponseEntity<APIResponse<PostResponsePage>> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    ResponseEntity<APIResponse<String>> reportJobPost(Long jobId, String comment, ReportCat reportCategory);

    ResponseEntity<APIResponse<List<JobPost>>> getJobPostByJobType(JobType jobType);

    ResponseEntity<APIResponse<JobPostResponse>> getJobPostById(Long id);

    ResponseEntity<APIResponse<List<JobPostResponse>>> searchJobs(String query);

    JobPostResponse jobPostToJobPostResponse(JobPost jobPost);

    ResponseEntity<APIResponse<List<JobPostResponse>>> getJobPostByStateAndCountry(String query);

    ResponseEntity<APIResponse<List<JobPostResponse>>> getJobPostByEmployerId(Long id);

    ResponseEntity<APIResponse<List<JobPostResponse>>> findJobPostsByEmployer();
}
