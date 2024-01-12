package com.jobmarket.jobmarketapp.repositories;


import com.jobmarket.jobmarketapp.entities.jobseeker.JobSeeker;
import com.jobmarket.jobmarketapp.entities.jobseeker.profile.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificationRepository extends JpaRepository<Certification, Long> {
    Certification findByIdAndJobSeeker_Id(Long id, Long jobSeekerId);
    List<Certification> findAllByJobSeeker(JobSeeker jobSeeker);
}
