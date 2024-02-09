package com.jobmarket.jobmarketapp.services.serviceImpl;


import com.jobmarket.jobmarketapp.entities.employer.Employer;
import com.jobmarket.jobmarketapp.entities.jobseeker.JobSeeker;
import com.jobmarket.jobmarketapp.exceptions.ApplicationException;
import com.jobmarket.jobmarketapp.payload.response.APIResponse;
import com.jobmarket.jobmarketapp.repositories.EmployerRepository;
import com.jobmarket.jobmarketapp.repositories.JobSeekerRepository;
import com.jobmarket.jobmarketapp.security.JwtTokenProvider;
import com.jobmarket.jobmarketapp.services.GeneralUserService;
import com.jobmarket.jobmarketapp.utils.HelperClass;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GeneralUserServiceImpl implements GeneralUserService {
    private final HttpServletRequest request;
    private final FileUploadImpl fileUpload;
    private final JwtTokenProvider jwtTokenProvider;
    private final JobSeekerRepository jobSeekerRepository;
    private final EmployerRepository employerRepository;
    private final HelperClass helperClass;

    @Override
    public ResponseEntity<APIResponse<String>> uploadProfilePic(MultipartFile profilePic) {
        String token = helperClass.getTokenFromHttpRequest(request);
        String email = jwtTokenProvider.getUserName(token);

        Optional<JobSeeker> jobSeekerOptional = jobSeekerRepository.findByEmail(email);
        Optional<Employer> employerOptional = employerRepository.findByEmail(email);

        String fileUrl = null;

        try {
            if (jobSeekerOptional.isPresent()) {
                fileUrl = fileUpload.uploadFile(profilePic);

                JobSeeker jobSeeker = jobSeekerOptional.get();
                jobSeeker.setProfilePicture(fileUrl);

                jobSeekerRepository.save(jobSeeker);
            } else if (employerOptional.isPresent()) {
                fileUrl = fileUpload.uploadFile(profilePic);

                Employer employer = employerOptional.get();
                employer.setProfilePicture(fileUrl);

                employerRepository.save(employer);
            }
        } catch (IOException e) {
            throw new ApplicationException("File upload error, please try again");
        }
         return ResponseEntity.ok(
                 new APIResponse<>(
                         "successful",
                         fileUrl
                 )
         );
    }
}
