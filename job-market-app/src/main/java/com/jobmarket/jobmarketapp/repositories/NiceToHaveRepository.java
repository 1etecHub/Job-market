package com.jobmarket.jobmarketapp.repositories;


import com.jobmarket.jobmarketapp.entities.jobpost.JobPost;
import com.jobmarket.jobmarketapp.entities.jobpost.NiceToHave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NiceToHaveRepository extends JpaRepository<NiceToHave, Long> {
    List<NiceToHave> findAllByJobPost(JobPost jobPost);
}
