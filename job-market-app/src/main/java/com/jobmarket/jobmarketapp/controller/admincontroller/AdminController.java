package com.jobmarket.jobmarketapp.controller.admincontroller;


import com.jobmarket.jobmarketapp.payload.response.APIResponse;
import com.jobmarket.jobmarketapp.payload.response.employerresponse.EmployerResponse;
import com.jobmarket.jobmarketapp.payload.response.jsresponse.JobSeekerResponse;
import com.jobmarket.jobmarketapp.services.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/employer/{employerId}")
    public ResponseEntity<APIResponse<EmployerResponse>> getEmployerById(@PathVariable Long employerId) {
        return adminService.getEmployerById(employerId);
    }

    @GetMapping("/jobseeker/{jobSeekerId}")
    public ResponseEntity<APIResponse<JobSeekerResponse>> getJobSeekerById(@PathVariable Long jobSeekerId) {
        return adminService.getJobSeekerById(jobSeekerId);
    }
}
