package com.jobmarket.jobmarketapp.repositories;


import com.jobmarket.jobmarketapp.entities.jobseeker.JobSeeker;
import com.jobmarket.jobmarketapp.entities.jobseeker.profile.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Long> {
    Education findByIdAndJobSeeker_Id(Long id, Long jobSeekerId);
    List<Education> findAllByJobSeeker(JobSeeker jobSeeker);
}
