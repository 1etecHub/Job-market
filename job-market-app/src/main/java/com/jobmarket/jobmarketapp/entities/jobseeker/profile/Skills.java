package com.jobmarket.jobmarketapp.entities.jobseeker.profile;


import com.jobmarket.jobmarketapp.entities.base.Base;
import com.jobmarket.jobmarketapp.entities.enums.YearsOfExp;
import com.jobmarket.jobmarketapp.entities.jobseeker.JobSeeker;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "skills")
public class Skills extends Base {
    private String skill;

    @Enumerated(EnumType.STRING)
    private YearsOfExp yearsOfExperience;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;
}
