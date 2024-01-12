package com.jobmarket.jobmarketapp.repositories;


import com.jobmarket.jobmarketapp.entities.jobpost.JobPost;
import com.jobmarket.jobmarketapp.entities.jobpost.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QualificationRepository extends JpaRepository<Qualification, Long> {
    List<Qualification> findAllByJobPost(JobPost jobPost);
}
