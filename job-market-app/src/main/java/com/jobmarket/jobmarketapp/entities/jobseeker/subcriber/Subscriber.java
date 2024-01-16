package com.jobmarket.jobmarketapp.entities.jobseeker.subcriber;


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
@Table(name = "subscribers")
public class Subscriber extends Base {
    @ManyToOne
    @JoinColumn(name = "jobseeker_Id")
    private JobSeeker jobSeeker;

    @Enumerated(EnumType.STRING)
    private Industry subscribedIndustry;
}
