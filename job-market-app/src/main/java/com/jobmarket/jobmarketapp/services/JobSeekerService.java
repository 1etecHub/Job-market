package com.jobmarket.jobmarketapp.services;


import com.jobmarket.jobmarketapp.entities.enums.Industry;
import com.jobmarket.jobmarketapp.entities.jobseeker.JobSeeker;
import com.jobmarket.jobmarketapp.entities.jobseeker.subcriber.Subscriber;
import com.jobmarket.jobmarketapp.entities.notification.Notification;
import com.jobmarket.jobmarketapp.event.events.JobPostCreatedEvent;
import com.jobmarket.jobmarketapp.payload.request.authrequests.ResetPasswordRequest;
import com.jobmarket.jobmarketapp.payload.request.jsrequests.jsprofilerequests.*;
import com.jobmarket.jobmarketapp.payload.response.APIResponse;
import com.jobmarket.jobmarketapp.payload.response.NotificationResponse;
import com.jobmarket.jobmarketapp.payload.response.authresponse.ResetPasswordResponse;
import com.jobmarket.jobmarketapp.payload.response.jsresponse.JobSeekerResponsePage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface JobSeekerService {
     ResponseEntity<APIResponse<ResetPasswordResponse>> resetPassword(HttpServletRequest request, ResetPasswordRequest resetPasswordRequest);
     void deleteMyAccount();

     JobSeeker getJobSeeker();

     // UPDATE PROFILE

     ResponseEntity<APIResponse<String>> contactInfoUpdate(JSContactInfoRequest contactInfoRequest);

     ResponseEntity<APIResponse<String>> locationInfoUpdate(JSLocationInfoRequest locationInfoRequest);

     ResponseEntity<APIResponse<String>> resumeUpdate(MultipartFile resume);
     ResponseEntity<APIResponse<String>> coverLetterUpdate(MultipartFile coverLetter);

     ResponseEntity<APIResponse<String>> workExperienceUpdate(JSWorkExperienceRequest workExperience, long id);

     ResponseEntity<APIResponse<String>> educationUpdate(EducationRequest educationRequest, long id);

     ResponseEntity<APIResponse<String>> skillsUpdate(SkillsRequest skillsRequest, long id);

     ResponseEntity<APIResponse<String>> licenseUpdate(LicenseRequest licenseRequest, long id);

     ResponseEntity<APIResponse<String>> certificationUpdate(CertificationRequest certificationRequest, long id);

     ResponseEntity<APIResponse<String>> languageUpdate(LanguageRequest languageRequest, long id);

     ResponseEntity<APIResponse<String>> jobPreferenceUpdate(JobPreferenceRequest preferenceRequest, long id);

     ResponseEntity<APIResponse<String>> jobExpectationUpdate(JobExpectationsRequest jobExpectationsRequest);

     ResponseEntity<APIResponse<String>> socialsUpdate(JSSocialsRequests socialsRequests);


     // CREATING NEW PROFILE

     ResponseEntity<APIResponse<String>> newWorkExperience(JSWorkExperienceRequest workExperience);

     ResponseEntity<APIResponse<String>> newEducation(EducationRequest educationRequest);

     ResponseEntity<APIResponse<String>> newSkills(SkillsRequest skillsRequest);

     ResponseEntity<APIResponse<String>> newLicense(LicenseRequest licenseRequest);

     ResponseEntity<APIResponse<String>> newCertification(CertificationRequest certificationRequest);

     ResponseEntity<APIResponse<String>> newLanguage(LanguageRequest languageRequest);

     ResponseEntity<APIResponse<String>> newJobPreference(JobPreferenceRequest preferenceRequest);

     ResponseEntity<APIResponse<JobSeekerResponsePage>> getAllJobSeekers(int pageNo, int pageSize, String sortBy, String sortDir);




     List<JobSeeker> getSubscribersByIndustry(Industry industry);

     void subscribeJobSeekerToIndustry(List<Industry> industries);

     boolean isSubscribed(String jobSeekerId, Industry industry);

     void subscribe(Subscriber subscriber);

     void handleJobPostCreatedEvent(JobPostCreatedEvent event);

     void sendNotification(Notification notification);

     void markNotificationAsRead(Long notificationId);

     ResponseEntity<APIResponse<List<NotificationResponse>>>  getNotifications();
}
