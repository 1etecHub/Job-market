package com.jobmarket.jobmarketapp.services.serviceImpl;


import com.jobmarket.jobmarketapp.entities.employer.Employer;
import com.jobmarket.jobmarketapp.entities.jobpost.JobPost;
import com.jobmarket.jobmarketapp.event.eventpublisher.EventPublisher;
import com.jobmarket.jobmarketapp.exceptions.ApplicationException;
import com.jobmarket.jobmarketapp.payload.request.authrequests.ResetPasswordRequest;
import com.jobmarket.jobmarketapp.payload.request.employerreqests.EmployerProfileContactInfoRequest;
import com.jobmarket.jobmarketapp.payload.request.employerreqests.EmployerUpdateProfileRequest;
import com.jobmarket.jobmarketapp.payload.response.APIResponse;
import com.jobmarket.jobmarketapp.payload.response.employerresponse.EmployerResponse;
import com.jobmarket.jobmarketapp.payload.response.employerresponse.EmployerResponsePage;
import com.jobmarket.jobmarketapp.repositories.EmployerRepository;
import com.jobmarket.jobmarketapp.repositories.JobPostRepository;
import com.jobmarket.jobmarketapp.security.JwtTokenProvider;
import com.jobmarket.jobmarketapp.services.EmployerService;
import com.jobmarket.jobmarketapp.utils.HelperClass;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployerServiceImpl implements EmployerService {
    private final AuthenticationManager authenticationManager;
    private final EmployerRepository employerRepository;
    private final HelperClass helperClass;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;
    private final EventPublisher eventPublisher;
    private final HttpServletRequest httpRequest;
    private final JobPostRepository jobPostRepository;
    private final ModelMapper mapper;


    @Override
    public Employer getEmployer() {
        String token = helperClass.getTokenFromHttpRequest(httpRequest);

        String email = jwtTokenProvider.getUserName(token);

        return  employerRepository
                .findByEmail(email)
                .orElseThrow(() -> new ApplicationException("User does not exist with email " + email));
    }

    @Override
    public ResponseEntity<APIResponse<String>> resetPassword(HttpServletRequest request, ResetPasswordRequest resetPasswordRequest) {
        String token = helperClass.getTokenFromHttpRequest(request);

        String email = jwtTokenProvider.getUserName(token);

        // Authentication manager to authenticate user
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        email,
                        resetPasswordRequest.getOldPassword()
                )
        );

        Employer employer = employerRepository
                    .findByEmail(email)
                    .orElseThrow(() -> new ApplicationException("User does not exist with email " + email));

        employer.setPassword(passwordEncoder.encode(resetPasswordRequest.getNewPassword()));

        employerRepository.save(employer);

        eventPublisher.notificationMailEventPublisher(email,
                employer.getFirstName(), "Password Reset",
                "Password successfully changed. If you did not initiate this, please send a reply to this email",
                request);

        return ResponseEntity.ok(new APIResponse<>("Password successfully changed"));
    }

    @Override
    public ResponseEntity<APIResponse<String>> updateProfileCompanyInfo(EmployerUpdateProfileRequest updateProfileRequest) {
        String token = helperClass.getTokenFromHttpRequest(httpRequest);

        String email = jwtTokenProvider.getUserName(token);

        Employer employer = employerRepository.findByEmail(email).get();

        employer.setCompanyName(updateProfileRequest.getCompanyName());
        employer.setCompanyDescription(updateProfileRequest.getCompanyDescription());
        employer.setAddress(updateProfileRequest.getAddress());
        employer.setCountry(updateProfileRequest.getCountry());
        employer.setState(updateProfileRequest.getState());
        employer.setIndustry(updateProfileRequest.getIndustry());
        employer.setCompanyType(updateProfileRequest.getCompanyType());
        employer.setNumberOfEmployees(updateProfileRequest.getNumberOfEmployees());
        employer.setWebsite(updateProfileRequest.getWebsite());
        employer.setFacebook(updateProfileRequest.getFacebook());
        employer.setTwitter(updateProfileRequest.getTwitter());
        employer.setInstagram(updateProfileRequest.getInstagram());

        Employer savedEmployer = employerRepository.save(employer);

        return ResponseEntity.ok(new APIResponse<>("Update Successful"));
    }

    @Override
    public ResponseEntity<APIResponse<String>> updateProfileContactInfo(EmployerProfileContactInfoRequest updateProfileRequest) {
        String token = helperClass.getTokenFromHttpRequest(httpRequest);

        String email = jwtTokenProvider.getUserName(token);

        Employer employer = employerRepository.findByEmail(email).get();

        employer.setFirstName(employer.getFirstName());
        employer.setLastName(employer.getLastName());
        employer.setPhoneNumber(employer.getPhoneNumber());
        employer.setPostalCode(employer.getPostalCode());

        Employer savedEmployer = employerRepository.save(employer);

        return ResponseEntity.ok(new APIResponse<>("Update Successful"));
    }

    @Override
    public ResponseEntity<APIResponse<String>> deleteJobPost(String email, Long postId) {

        Optional<JobPost> jobPostOptional = jobPostRepository.findById(postId);

        Optional<Employer> employerOptional = employerRepository.findByEmail(email);

        // Check if the employer with the specified email exists
        if (employerOptional.isPresent()) {
            // Check if the job post exists
            if (jobPostOptional.isPresent()) {
                // Check if the employer associated with the job post is the same as the logged-in employer
                if (jobPostOptional.get().getEmployer().equals(employerOptional.get())) {
                    // If yes, delete the job post
                    jobPostRepository.delete(jobPostOptional.get());
                    return ResponseEntity.ok(new APIResponse<>("Post successfully deleted"));
                }
                // If not, throw an exception indicating that the user is not permitted to delete this post
                throw new ApplicationException("You are not permitted to delete this post");
            }
            // If the job post with the specified ID does not exist
            throw new ApplicationException("Job post not found");
        }
        // If the employer with the specified email does not exist
        throw new ApplicationException("Employer not found");
    }

    @Override
    public ResponseEntity<EmployerResponsePage> getAllEmployers(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of( pageNo, pageSize, sort);

        Slice<Employer> employers = employerRepository.findAll(pageable);

        List<Employer> employerList = employers.getContent();

        List<EmployerResponse> content = employerList.stream()
                .map(employer -> mapper.map(employer, EmployerResponse.class))
                .toList();

        return ResponseEntity.ok(
                EmployerResponsePage.builder()
                        .content(content)
                        .pageNo(employers.getNumber())
                        .pageSize(employers.getSize())
                        .totalElement(employers.getNumberOfElements())
                        .last(employers.isLast())
                        .build()
        );
    }
}
