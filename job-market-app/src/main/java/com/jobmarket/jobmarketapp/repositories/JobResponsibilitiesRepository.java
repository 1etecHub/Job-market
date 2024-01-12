package com.jobmarket.jobmarketapp.repositories;


import com.jobmarket.jobmarketapp.entities.jobpost.JobPost;
import com.jobmarket.jobmarketapp.entities.jobpost.JobResponsibilities;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobResponsibilitiesRepository extends JpaRepository<JobResponsibilities,Long> {
    List<JobResponsibilities> findByJobPost_Id(Long id);

    List<JobResponsibilities> findAllByJobPost(JobPost jobPost);
}
