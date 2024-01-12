package com.jobmarket.jobmarketapp.repositories;


import com.jobmarket.jobmarketapp.entities.employer.Employer;
import com.jobmarket.jobmarketapp.entities.enums.EmploymentType;
import com.jobmarket.jobmarketapp.entities.enums.ExperienceLevel;
import com.jobmarket.jobmarketapp.entities.enums.JobType;
import com.jobmarket.jobmarketapp.entities.jobpost.JobPost;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JobPostRepository extends JpaRepository<JobPost, Long> {
    Optional<JobPost> findByIdAndEmployer(Long id, Employer employer);

    List<JobPost> findJobPostsByEmployerId(Long employer_id);

    List<JobPost> findAllByJobType(JobType jobType);

    Slice<JobPost> findAllByExperienceLevel(ExperienceLevel experienceLevel, Pageable pageable);

    List<JobPost> findJobPostsByJobTypeOrJobTypeOrJobTypeOrEmploymentTypeOrEmploymentTypeOrEmploymentTypeOrEmploymentTypeOrExperienceLevelOrExperienceLevelOrExperienceLevelOrExperienceLevelOrExperienceLevelOrderByCreateDateDesc(JobType jobType,
                                                                                                                                                                                                                                    JobType jobType2,
                                                                                                                                                                                                                                    JobType jobType3,
                                                                                                                                                                                                                                    EmploymentType employmentType,
                                                                                                                                                                                                                                    EmploymentType employmentType2,
                                                                                                                                                                                                                                    EmploymentType employmentType3,
                                                                                                                                                                                                                                    EmploymentType employmentType4,
                                                                                                                                                                                                                                    ExperienceLevel experienceLevel,
                                                                                                                                                                                                                                    ExperienceLevel experienceLevel2,
                                                                                                                                                                                                                                    ExperienceLevel experienceLevel3,
                                                                                                                                                                                                                                    ExperienceLevel experienceLevel4,
                                                                                                                                                                                                                                    ExperienceLevel experienceLevel5);

    @Query(value = "SELECT * FROM job_post " +
            "WHERE LOWER(title) LIKE LOWER(CONCAT('%', :query, '%')) " +
            "OR LOWER(job_category) LIKE LOWER(CONCAT('%', :query, '%'))",
            nativeQuery = true)
    List<JobPost> searchJobs(@Param("query") String query);

    @Query(value = "SELECT * FROM job_post " +
            "WHERE LOWER(state) LIKE LOWER(CONCAT('%', :query, '%')) " +
            "OR LOWER(country) LIKE LOWER(CONCAT('%', :query, '%')) ",
            nativeQuery = true)
    List<JobPost> findByStateAndCountry(String query);

    List<JobPost> findJobPostsByEmployer(Employer employer);
}



