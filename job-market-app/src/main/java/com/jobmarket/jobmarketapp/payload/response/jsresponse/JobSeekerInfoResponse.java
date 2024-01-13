package com.jobmarket.jobmarketapp.payload.response.jsresponse;

import com.swiftselect.domain.entities.jobseeker.profile.*;
import com.swiftselect.domain.enums.Gender;
import com.swiftselect.domain.enums.JobType;
import com.swiftselect.domain.enums.PayRate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
public class JobSeekerInfoResponse {
    Long id;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    String profilePicture;
    String country;
    String state;
    String city;
    String address;
    String postalCode;
    String facebook;
    String twitter;
    String instagram;
    Gender gender;
    LocalDate dateOfBirth;
    String resume;
    String coverLetter;
    String workSchedule;
    String basePay;
    PayRate payRate;
    JobType jobType;
    List<EducationResponse> education;
    List<WorkExperienceResponse> workExperiences;
    List<SkillsResponse> skills;
    List<CertificationsResponse> certifications;
}
