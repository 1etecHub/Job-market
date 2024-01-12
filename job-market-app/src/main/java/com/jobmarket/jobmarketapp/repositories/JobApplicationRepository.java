package com.jobmarket.jobmarketapp.repositories;


import com.jobmarket.jobmarketapp.entities.jobpost.Applications;
import com.jobmarket.jobmarketapp.entities.jobpost.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobApplicationRepository extends JpaRepository<Applications, Long> {
    Optional<Applications> findByJobSeekerEmail(String email);

    List<Applications> findAllByJobPost(JobPost jobPost);

}
