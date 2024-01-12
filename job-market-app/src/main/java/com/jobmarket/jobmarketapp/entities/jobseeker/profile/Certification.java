package com.jobmarket.jobmarketapp.entities.jobseeker.profile;

import com.swiftselect.domain.entities.base.Base;
import com.swiftselect.domain.entities.jobseeker.JobSeeker;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "certification")
public class Certification extends Base {
    private String name;

    private String expiration;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;
}
