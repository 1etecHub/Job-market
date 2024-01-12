package com.jobmarket.jobmarketapp.entities.jobseeker.profile;


import com.jobmarket.jobmarketapp.entities.base.Base;
import com.jobmarket.jobmarketapp.entities.jobseeker.JobSeeker;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "work_experience")
public class WorkExperience extends Base {
    private String jobTitle;

    private String companyName;

    private LocalDate startDate;

    private LocalDate stopDate;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;
}
