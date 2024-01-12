package com.jobmarket.jobmarketapp.repositories;


import com.jobmarket.jobmarketapp.entities.jobseeker.JobSeeker;
import com.jobmarket.jobmarketapp.entities.jobseeker.profile.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillsRepository extends JpaRepository<Skills, Long> {
    Skills findByIdAndJobSeeker_Id(Long id, Long jobSeekerId);
    List<Skills> findAllByJobSeeker(JobSeeker jobSeeker);
}
