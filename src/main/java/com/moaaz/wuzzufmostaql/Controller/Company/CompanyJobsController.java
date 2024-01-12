package com.moaaz.wuzzufmostaql.Controller.Company;

import com.moaaz.wuzzufmostaql.Dto.Company.JobDto;
import com.moaaz.wuzzufmostaql.Dto.Company.JobResponse;
import com.moaaz.wuzzufmostaql.Model.Application.Job;
import com.moaaz.wuzzufmostaql.Model.Company.Company;
import com.moaaz.wuzzufmostaql.Service.Company.CompanyJobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moaaz/wuzzufmostql/api/companies/jobs")
public class CompanyJobsController {

    @Autowired
    private CompanyJobService companyJobService;
    @GetMapping("/getAll/{companyId}")
    @ResponseStatus(HttpStatus.OK)
    public List<JobResponse> getAllJobs(@PathVariable long companyId){
        return companyJobService.getAllJobs(companyId);
    }

    @PostMapping("/add/{companyId}")
    public Company addJob(@RequestBody@Valid JobDto jobDto , @PathVariable long companyId){
        return companyJobService.addJobToCompany(jobDto , companyId);
    }

    @PutMapping("/close/{jobId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String closeJob(@PathVariable long jobId){
        companyJobService.closeJob(jobId);
        return "Job Closed Successfully....";
    }


    @GetMapping("/searchByTitle")
    public List<Job>getJobsAllByTitle(@RequestParam String jobTitle){
        return companyJobService.getAllJobsByTitle(jobTitle);
    }



}
