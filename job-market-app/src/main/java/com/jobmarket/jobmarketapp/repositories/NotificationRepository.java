package com.jobmarket.jobmarketapp.repositories;


import com.jobmarket.jobmarketapp.entities.jobseeker.JobSeeker;
import com.jobmarket.jobmarketapp.entities.notification.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
    List<Notification> findAllByRecipientOrderByCreateDateDesc(JobSeeker recipient);
}
