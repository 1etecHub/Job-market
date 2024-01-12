package com.jobmarket.jobmarketapp.repositories;


import com.jobmarket.jobmarketapp.entities.jobseeker.profile.License;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseRepository extends JpaRepository<License, Long> {
    License findByIdAndJobSeeker_Id(Long id, Long jobSeekerId);
}
