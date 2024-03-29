package com.jobmarket.jobmarketapp.security;


import com.jobmarket.jobmarketapp.entities.admin.Admin;
import com.jobmarket.jobmarketapp.entities.employer.Employer;
import com.jobmarket.jobmarketapp.entities.jobseeker.JobSeeker;
import com.jobmarket.jobmarketapp.repositories.AdminRepository;
import com.jobmarket.jobmarketapp.repositories.EmployerRepository;
import com.jobmarket.jobmarketapp.repositories.JobSeekerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {
    private final EmployerRepository employerRepository;
    private final JobSeekerRepository jobSeekerRepository;
    private final AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if (employerRepository.existsByEmail(email)) {
            Employer employer = employerRepository.findByEmail(email).get();

            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority(employer.getRole().toString()));

            return new User(
                    employer.getEmail(),
                    employer.getPassword(),
                    authorities
            );
        } else if (jobSeekerRepository.existsByEmail(email)) {
            JobSeeker jobSeeker = jobSeekerRepository.findByEmail(email).get();

            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority(jobSeeker.getRole().toString()));

            return new User(
                    jobSeeker.getEmail(),
                    jobSeeker.getPassword(),
                    authorities
            );
        } else if (adminRepository.existsByEmail(email)) {
            Admin admin = adminRepository.findByEmail(email).get();

            Set<GrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority(admin.getRole().toString()));

            return new User(
                    admin.getEmail(),
                    admin.getPassword(),
                    authorities
            );
        }

        throw new UsernameNotFoundException("User not found with email: " + email);
    }
}
