package com.jobmarket.jobmarketapp.event.eventListener;


import com.jobmarket.jobmarketapp.event.events.JobPostCreatedEvent;
import com.jobmarket.jobmarketapp.services.JobSeekerService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JobPostCreatedEventListener {

    private final JobSeekerService jobSeekerService;


    @EventListener
    public void handleJobPostCreatedEvent(JobPostCreatedEvent event) {
        jobSeekerService.handleJobPostCreatedEvent(event);
    }
}

