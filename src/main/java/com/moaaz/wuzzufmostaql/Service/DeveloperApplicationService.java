package com.moaaz.wuzzufmostaql.Service;

import com.moaaz.wuzzufmostaql.Dto.ApplicationDto;
import com.moaaz.wuzzufmostaql.Dto.DeveloperApplicationResponse;
import com.moaaz.wuzzufmostaql.Model.Application.Application;
import com.moaaz.wuzzufmostaql.Model.Application.ApplicationStatus;
import com.moaaz.wuzzufmostaql.Model.Application.Job;
import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import com.moaaz.wuzzufmostaql.Service.Developer.Imp.DeveloperService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class DeveloperApplicationService {


    @Autowired
    private DeveloperService developerService;
    @Autowired
    private JobService jobService;
    @Autowired
    private ApplicationService applicationService;

    @SneakyThrows
    public Developer registerApplication(ApplicationDto applicationDto) {

        Developer developer = developerService.getByIdOrElseThrowException(applicationDto.getDeveloperId());
        Job job = jobService.getById(applicationDto.getJobId());
        checkIfJobIsOpen(job);
        checkIfDeveloperAlreadyApplied(job, developer);

        Application application
                = Application
                .builder()
//                .developer(developer)
                .job(job)
                .answers(applicationDto.getAnswers())
                .selected(ApplicationStatus.WAITING)
                .dateTime(LocalDateTime.now())
                .build();
        applicationService.saveApplication(application);
        return developer;
    }

    public List<DeveloperApplicationResponse> getAllDeveloperApplications(long developerId) {
        Developer developer = developerService.getByIdOrElseThrowException(developerId);
        return developer.getApplications().stream().map(this::convertApplicationToDeveloperApplicationResponse).toList();
    }

    private DeveloperApplicationResponse convertApplicationToDeveloperApplicationResponse(Application application) {
        return DeveloperApplicationResponse
                .builder()
                .companyName(application.getJob().getCompany().getName())
                .companyPicturePath(application.getJob().getCompany().getBasePicture())
                .numbersOfApplications(application.getJob().getApplications().size())
                .questions(application.getJob().getQuestions())
                .requirements(application.getJob().getRequirements())
                .answers(application.getAnswers())
                .jobDateTime(application.getJob().getLocalDate())
                .applicationDateTime(application.getDateTime())
                .build();


    }

    @SneakyThrows
    private void checkIfJobIsOpen(Job job) {
        if (!job.isOpen())
            throw new Exception("This Job Is Closed...");
    }

    @SneakyThrows
    private void checkIfDeveloperAlreadyApplied(Job job, Developer developer) {
        log.info("Here In The Check Method...");
        if (job.getApplications().stream().anyMatch(app -> app.getDeveloper().equals(developer)))
            throw new Exception("This Developer Already Applied For This Job Before");
    }
}
