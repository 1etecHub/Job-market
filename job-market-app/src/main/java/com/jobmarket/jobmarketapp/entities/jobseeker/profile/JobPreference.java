package com.jobmarket.jobmarketapp.entities.jobseeker.profile;


import com.jobmarket.jobmarketapp.entities.base.Base;
import com.jobmarket.jobmarketapp.entities.enums.Industry;
import com.jobmarket.jobmarketapp.entities.jobseeker.JobSeeker;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "job_preference")
public class JobPreference extends Base {
    @Enumerated(EnumType.STRING)
    private Industry industry;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;
}
