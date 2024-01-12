package com.jobmarket.jobmarketapp.repositories;


import com.jobmarket.jobmarketapp.entities.enums.Industry;
import com.jobmarket.jobmarketapp.entities.jobseeker.subcriber.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriberRepository extends JpaRepository<Subscriber,Long> {
    List<Subscriber> findBySubscribedIndustry(Industry subscribedIndustry);

    boolean existsByJobSeeker_EmailAndSubscribedIndustry(String email, Industry industry);
}
