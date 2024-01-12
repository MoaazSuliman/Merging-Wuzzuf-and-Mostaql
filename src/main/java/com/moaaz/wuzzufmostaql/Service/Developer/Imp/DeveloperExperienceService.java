package com.moaaz.wuzzufmostaql.Service.Developer.Imp;

import com.moaaz.wuzzufmostaql.Dto.Developer.ExperienceRequest;
import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import com.moaaz.wuzzufmostaql.Model.Developer.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DeveloperExperienceService {

    @Autowired
    private DeveloperService developerService;

    public void addExperience(ExperienceRequest experienceRequest, long developerId) {
        Developer developer = developerService.getByIdOrElseThrowException(developerId);
        Experience experience
                = Experience
                .builder()
                .yearOfExperience(experienceRequest.getYearOfExperience())
                .companyName(experienceRequest.getCompanyName())
                .build();
        // add experience to developer
        developer.getExperiences().add(experience);
        // update developer in the database.
        developerService.updateDeveloper(developer);

    }


    public void updateExperience(ExperienceRequest experienceRequest, long experienceId, long developerId) {
        Developer developer = developerService.getByIdOrElseThrowException(developerId);

        Experience experience = (developer.getExperiences().stream()
                .filter(e -> e.getId() == experienceId).findFirst()
                .orElseThrow(
                        () -> new NoSuchElementException("There Are No Experience For This Developer With Id = " + experienceId))
        );
        experience.setYearOfExperience(experienceRequest.getYearOfExperience());
        experience.setCompanyName(experienceRequest.getCompanyName());

        //delete old experience
//        deleteExperience(experienceId, developerId);
//        developer.getExperiences().add(experience);
        // update developer
        developerService.updateDeveloper(developer);


    }

    public void deleteExperience(long experienceId, long developerId) {
        Developer developer = developerService.getByIdOrElseThrowException(developerId);
        Experience experience = (developer.getExperiences().stream()
                .filter(e -> e.getId() == experienceId).findFirst()
                .orElseThrow(
                        () -> new NoSuchElementException("There Are No Experience For This Developer With Id = " + experienceId))
        );

        // delete experience
        developer.getExperiences().remove(experience);
        // update developer
        developerService.updateDeveloper(developer);


    }
}
