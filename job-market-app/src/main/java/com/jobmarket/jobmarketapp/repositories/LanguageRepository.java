package com.jobmarket.jobmarketapp.repositories;


import com.jobmarket.jobmarketapp.entities.jobseeker.profile.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {
    Language findByIdAndJobSeeker_Id(Long id, Long jobSeekerId);
}
