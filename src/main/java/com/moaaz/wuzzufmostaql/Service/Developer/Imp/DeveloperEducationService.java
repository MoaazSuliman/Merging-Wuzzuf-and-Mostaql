package com.moaaz.wuzzufmostaql.Service.Developer.Imp;

import com.moaaz.wuzzufmostaql.Dto.Developer.EducationRequest;
import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import com.moaaz.wuzzufmostaql.Model.Developer.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeveloperEducationService {

    @Autowired
    private DeveloperService developerService;

    public void putEducation(EducationRequest educationRequest, long developerId) {
        Developer developer = developerService.getByIdOrElseThrowException(developerId);
        Education education = Education
                .builder()
                .universityName(educationRequest.getUniversityName())
                .facultyName(educationRequest.getFacultyName())
                .achievement(educationRequest.getAchievement())
                .fromYear(educationRequest.getFromYear())
                .toYear(educationRequest.getToYear())
                .build();

        if (developer.getEducation() != null)
            education.setId(developer.getEducation().getId());

        developer.setEducation(education);
        developerService.updateDeveloper(developer);

    }

    public void deleteEducation(long developerId) {
        Developer developer = developerService.getByIdOrElseThrowException(developerId);

        developer.setEducation(null);

        developerService.updateDeveloper(developer);
    }


}
