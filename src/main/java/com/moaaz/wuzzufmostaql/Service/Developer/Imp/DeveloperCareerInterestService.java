package com.moaaz.wuzzufmostaql.Service.Developer.Imp;

import com.moaaz.wuzzufmostaql.Dto.Developer.CareerInterestRequest;
import com.moaaz.wuzzufmostaql.Model.Developer.CareerInterests;
import com.moaaz.wuzzufmostaql.Model.Developer.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeveloperCareerInterestService {

    @Autowired
    private DeveloperService developerService;


    public Developer updateDeveloperWithNewCareerInterest(CareerInterestRequest careerInterestRequest, long developerId) {
        CareerInterests careerInterests = CareerInterests
                .builder()
                .careerLevel(careerInterestRequest.getCareerLevel())
                .jobTypes(careerInterestRequest.getJobTypes())
                .careerTitles(careerInterestRequest.getCareerTitles())
                .expectedSalary(careerInterestRequest.getExpectedSalary())
                .jobPositions(careerInterestRequest.getJobPositions())
                .build();
        // get developer to set new career interest for him
        Developer developer = developerService.getByIdOrElseThrowException(developerId);

        // check if he has career interest before to update it.
        if (developer.getCareerInterests() != null)
            careerInterests.setId(developer.getCareerInterests().getId());

        // set new career interest in developer
        developer.setCareerInterests(careerInterests);

        // update developer with new career interest in database.
        return developerService.updateDeveloper(developer);

    }


}
