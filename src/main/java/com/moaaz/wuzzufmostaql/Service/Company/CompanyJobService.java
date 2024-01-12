package com.moaaz.wuzzufmostaql.Service.Company;

import com.moaaz.wuzzufmostaql.Dto.ApplicationResponse;
import com.moaaz.wuzzufmostaql.Dto.Company.JobDto;
import com.moaaz.wuzzufmostaql.Dto.Developer.DeveloperResponse;
import com.moaaz.wuzzufmostaql.Dto.Company.JobResponse;
import com.moaaz.wuzzufmostaql.Model.Application.Application;
import com.moaaz.wuzzufmostaql.Model.Application.Job;
import com.moaaz.wuzzufmostaql.Model.Company.Company;
import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import com.moaaz.wuzzufmostaql.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CompanyJobService {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private JobService jobService;

    public Company addJobToCompany(JobDto jobDto, long companyId) {
        Company company = companyService.getByIdOrElseThrowException(companyId);
        Job job = Job
                .builder()
                .questions(jobDto.getQuestions())
                .requirements(jobDto.getRequirements())
                .details(jobDto.getDetails())
                .localDate(LocalDateTime.now())
                .company(company)
                .title(jobDto.getTitle())
                .build();
        company.getJobs().add(job);

        return companyService.updateCompany(company);
    }

    public void closeJob(long jobId) {
        Job job = jobService.getById(jobId);
        job.setOpen(false);
        jobService.updateJob(job);
    }

    public List<JobResponse> getAllJobs(long companyId) {
        Company company = companyService.getByIdOrElseThrowException(companyId);
        List<Job> jobs = company.getJobs();
        return jobs.stream().map(this::convertJobToJobResponse).toList();

    }

    private JobResponse convertJobToJobResponse(Job job) {
        return JobResponse
                .builder()
                .id(job.getId())
                .questions(job.getQuestions())
                .details(job.getDetails())
                .requirements(job.getRequirements())
                .open(job.isOpen())
                .localDate(job.getLocalDate())
                .applications(job.getApplications().stream()
                        .map(this::convertApplicationToApplicationResponse)
                        .toList())
                .build();

    }

    private ApplicationResponse convertApplicationToApplicationResponse(Application application) {
        return ApplicationResponse
                .builder()
                .developer(convertDeveloperToDeveloperResponse(application.getDeveloper()))
                .time(application.getDateTime())
                .build();
    }

    private DeveloperResponse convertDeveloperToDeveloperResponse(Developer developer) {
        return DeveloperResponse
                .builder()
                .name(developer.getGeneralInfo().getFirstName())
                .email(developer.getGeneralInfo().getEmail())
                .cvPath(developer.getGeneralInfo().getCvPath())
                .build();


    }


    public List<Job> getAllJobsByTitle(String jobTitle) {
        return jobService.getAllJobsByTitle(jobTitle);
    }
}
