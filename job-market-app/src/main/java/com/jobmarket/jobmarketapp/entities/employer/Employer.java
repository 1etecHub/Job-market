package com.jobmarket.jobmarketapp.entities.employer;


import com.jobmarket.jobmarketapp.entities.base.Person;
import com.jobmarket.jobmarketapp.entities.enums.CompanyType;
import com.jobmarket.jobmarketapp.entities.enums.Industry;
import com.jobmarket.jobmarketapp.entities.enums.Role;
import com.jobmarket.jobmarketapp.entities.jobpost.JobPost;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "employer")
public class Employer extends Person {
    private String companyName;

    private String companyDescription;

    private Long numberOfEmployees;

    private String website;

    private String facebook;

    private String twitter;

    private String instagram;

    private String position;

    @Enumerated(value = EnumType.STRING)
    private CompanyType companyType;

    @Enumerated(value = EnumType.STRING)
    private Industry industry;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
    private Set<JobPost> JobPosts = new HashSet<>();
}
